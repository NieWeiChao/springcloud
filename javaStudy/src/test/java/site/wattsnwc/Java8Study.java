package site.wattsnwc;

import org.junit.Test;

import site.wattsnwc.java8.lambda.stream.TestBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这里需要写注释
 */

public class Java8Study {
    @Test
    public void studyJava8 (){
        //comment
        String a = "asd";
        String aa = "asd";
        String aaa = new String("asd") ;
        System.out.println(a == aa);
        System.out.println(a.equals(aa));
        System.out.println(a ==aaa);
        Map<Integer,Integer> m = new HashMap<>();
        m.put(1,3);
        m.put(2,2);
        m.put(3,10);
        m.put(4,5);

        System.out.println(1|2);
    }
    
    @Test
    public void testList (){
        //comment
        List<TestBean> l = new ArrayList<>();
        TestBean t = new TestBean();
        for(int i =0;i<5;i++){
            t.setName("name"+i);
            l.add(t);
        }
        System.out.println(l);
    }

    @Test
    public void tt (){
        //comment
        System.out.println(
                String.format(" %2$s分公司/中心定核损管理指标统计%1$4tY-%1$2tm",new Date(),"123" )
                );
    }
    @org.junit.Test
    public void asd () {
        System.out.println(123333333);
    }

    public static void main(String[] args) {
        if(System.out.printf("a")==null){
            System.out.print("a");
        }else{
            System.out.print("b");
        }
    }
}
