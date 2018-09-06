package site.wattsnwc.java8.lambda.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 这里需要写注释
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<TestBean> list = Arrays.asList(
                TestBean.newInstance(),TestBean.newInstance(),
                TestBean.newInstance(),TestBean.newInstance(),
                TestBean.newInstance());

        list.forEach(testBean -> {
            System.out.println("name:"+testBean.getName()+";age:"+testBean.getAge());
        });
        System.out.println();
        list.stream().filter(t -> t.getAge()<50).forEach(testBean -> System.out.println("name:"+testBean.getName()+";age:"+testBean.getAge()));
        System.out.println();
        list.stream().map(TestBean::getName).forEach(System.out::println);
        System.out.println();
        System.out.println(list.stream().anyMatch(t -> t.getAge()>10));
        System.out.println(list.stream().findFirst().orElse(null).getAge());
        list.stream().collect(Collectors.toMap(TestBean::getAge, TestBean::getName)).forEach((age, name) -> {
            System.out.println(age);
            System.out.println(name);
        });

        new HashSet<>(list).forEach(e ->System.out.println(e.getAge()));

        System.out.println(0x2);
        System.out.println('z');
        System.out.println((int)'a');
    }
}
