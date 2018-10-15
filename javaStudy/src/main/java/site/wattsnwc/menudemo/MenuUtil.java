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
        firstMenus.forEach(menu ->
                copyMenus.stream()
                        .filter(otherMenu -> otherMenu.getPId().equals(menu.getId()))
                        .peek(otherMenu -> {
                            if(needCheck.contains(otherMenu.getName())){
                                otherMenu.setChecked(true);
                            }
                        })
                        .forEach(otherMenu -> {
                            menu.addSubs(otherMenu);
                            copyMenus.remove(otherMenu);
                        })
        );
        firstMenus.stream()
                .filter(menu -> menu.getSubs()!=null)
                .forEach(menu -> buildMenuTree(menu.getSubs(), copyMenus,needCheck));
    }

    static List<Menu> buildTree(List<Menu> menus,final List<String> needCheck ){
        //取到顶级节点集合或者顶级ID为 ** 的集合
        List<Menu> firstMenus = menus.stream().filter(menu -> null == menu.getPId()).peek(menu -> {
            if(needCheck.contains(menu.getName())){
                menu.setChecked(true);
            }
        }).collect(Collectors.toList());
        menus.removeAll(firstMenus);
        MenuUtil.buildMenuTree(firstMenus, menus,needCheck);
        return firstMenus;
    }
}
