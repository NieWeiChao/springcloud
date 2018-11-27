package site.wattsnwc.menudemo;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Test;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

/**
 * 这里需要写注释
 */
public class MenuTestTest {
    private static long start = Clock.systemDefaultZone().millis();

    @After
    public void tearDown() {
        //耗时
        System.out.printf("time : %s \n" , Clock.systemDefaultZone().millis()-start);
    }

    @Test
    public void testMenu (){
        //需要选中的名称列表
        List<String> needCheck = new ArrayList<>(3);
        needCheck.add("2");needCheck.add("2-1");needCheck.add("3-2");
        //遍历树
        List<Menu> tree =  MenuUtil.buildTree(buildMockMenus(),needCheck );
        //查看结果
        System.out.println(JSON.toJSON(tree));
        System.out.print("no8");
    }

    @Test
    public void testMeuJava8 (){
        //comment
        //需要选中的名称列表
        List<String> needCheck = new ArrayList<>(3);
        needCheck.add("2");needCheck.add("2-1");needCheck.add("3-2");
        System.out.println(JSON.toJSON(MenuUtil.buildMenuTreeJava8(buildMockMenus(),needCheck)));
    }
    /**
     * 假数据
     * @return 假数据
     */
    private static List<Menu> buildMockMenus(){
        Menu m0 = Menu.builder().id(0L).pId(-1L).name("1").build();
        Menu m1 = Menu.builder().id(1L).pId(0L).name("1").build();
        Menu m2 = Menu.builder().id(2L).pId(0L).name("2").build();
        Menu m3 = Menu.builder().id(3L).pId(0L).name("3").build();
        Menu m4 = Menu.builder().id(11L).pId(1L).name("1-1").build();
        Menu m5 = Menu.builder().id(12L).pId(1L).name("1-2").build();
        Menu m6 = Menu.builder().id(21L).pId(2L).name("2-1").build();
        Menu m7 = Menu.builder().id(22L).pId(2L).name("2-2").build();
        Menu m8 = Menu.builder().id(31L).pId(3L).name("3-1").build();
        Menu m9 = Menu.builder().id(32L).pId(3L).name("3-2").build();
        Menu m10 = Menu.builder().id(111L).pId(11L).name("1-1-1").build();
        Menu m11 = Menu.builder().id(112L).pId(11L).name("1-1-2").build();
        List<Menu> menus = new ArrayList<>();
        menus.add(m0);
        menus.add(m1);
        menus.add(m2);
        menus.add(m3);
        menus.add(m4);
        menus.add(m5);
        menus.add(m6);
        menus.add(m7);
        menus.add(m8);
        menus.add(m9);
        menus.add(m10);
        menus.add(m11);
        return menus;
    }


}