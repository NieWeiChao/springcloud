package site.wattsnwc.menudemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 这里需要写注释
 */
public class MenuUtil {

    private static void buildMenuTree(List<Menu> firstMenus, List<Menu> menus,final List<String> needCheck ){
        //递归并行,使用线程安全集合处理
        List<Menu> copyMenus = new CopyOnWriteArrayList<>(menus);
        //先找到PID等于当前节点ID的集合
        firstMenus.forEach(menu ->
                copyMenus.stream()
                        //过滤等于PID的节点
                        .filter(otherMenu -> otherMenu.getPId().equals(menu.getId()))
                        //peek赋值是否选中
                        .peek(otherMenu -> {
                            if(needCheck.contains(otherMenu.getName())){
                                otherMenu.setChecked(true);
                            }
                        })
                        //遍历节点:添加到子节点,并从剩余节点移除
                        .forEach(otherMenu -> {
                            menu.addSubs(otherMenu);
                            copyMenus.remove(otherMenu);
                        })
        );
        //子节点不为空,继续递归查找子节点下的子节点
        firstMenus.stream()
                .filter(menu -> menu.getSubs()!=null)
                .forEach(menu -> buildMenuTree(menu.getSubs(), copyMenus,needCheck));
    }

    static List<Menu> buildTree(List<Menu> menus,final List<String> needCheck ){
        //取到顶级节点集合或者顶级ID为 ** 的集合
        List<Menu> firstMenus = menus.stream()
                .filter(menu -> null == menu.getPId() || menu.getPId()==-1L)
                //peek赋值是否选中
                .peek(menu -> {
                    if(needCheck.contains(menu.getName())){
                        menu.setChecked(true);
                    }
                })
                //集合
                .collect(Collectors.toList());
        menus.removeAll(firstMenus);
        MenuUtil.buildMenuTree(firstMenus, menus,needCheck);
        return firstMenus;
    }

    /**
     * java8大法
     * @return
     */
    static List<Menu> buildMenuTreeJava8(List<Menu> datas,final List<String> needCheck){
        Objects.requireNonNull(datas,"datas not null");
        //所有节点缓存
        Map<Long, Menu> cache = new HashMap<>(datas.size());
        //steam流
        Supplier<Stream<Menu>> stream = datas::stream;
        //根据PID分组
        Map<Long, List<Menu>> treeCache = stream.get()
                .peek(node -> {
                    cache.put(node.getId(),node);
                    if(needCheck.contains(node.getName())){
                        node.setChecked(true);
                    }
                })
                .collect(Collectors.groupingBy(Menu::getPId));
        //抽取数据
        List<Menu> result = stream.get()
                .peek(menu -> menu.setSubs(treeCache.get(menu.getId())))
                .filter(menu -> null == menu.getPId() || menu.getPId()==-1L).collect(Collectors.toList());
        return result;
    }
    /**
     * 树结构Helper
     *
     * @param <T>  节点类型
     * @param <PK> 主键类型
     */
    interface TreeHelper<T, PK> {
        /**
         * 根据主键获取子节点
         *
         * @param parentId 节点ID
         * @return 子节点集合
         */
        List<T> getChildren(PK parentId);

        /**
         * 根据id获取节点
         *
         * @param id 节点ID
         * @return 节点
         */
        T getNode(PK id);
        //add develop 123
    }
}
