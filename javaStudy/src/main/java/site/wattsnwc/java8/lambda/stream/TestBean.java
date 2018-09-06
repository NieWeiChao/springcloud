package site.wattsnwc.java8.lambda.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Random;

/**
 * 这里需要写注释
 */
@Data
@EqualsAndHashCode
public class TestBean {

    private int age;

    private String name;

    private String email ;

    private String sex;

    static TestBean newInstance(){
        TestBean b = new TestBean();
        b.setAge(new Random().nextInt(100));
        b.setName("name"+new Random().nextInt(3));
        b.setEmail("email"+new Random().nextInt(3));
        b.setSex("sex"+new Random().nextInt(3));
        return b;
    }


}
