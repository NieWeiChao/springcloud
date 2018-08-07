package site.wattsnwc.properties;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    WattsProperties properties;

    @org.junit.Test
    public void testProperties() {
        System.out.println(properties.getRandom());
        Assert.assertEquals(properties.getName(),"Watts1");
    }

    @org.junit.Test
    public void testarr (){
        //comment
        System.out.println(new String[]{"1","2"}[1]);
    }
}
