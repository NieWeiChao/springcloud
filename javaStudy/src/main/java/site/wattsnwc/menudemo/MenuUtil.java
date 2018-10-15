package site.wattsnwc.menudemo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

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
                .filter(menu -> null == menu.getPId())
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
}
