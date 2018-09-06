package site.wattsnwc.java8.simpleaop;

/**
 * 这里需要写注释
 */
public class HelloServiceImpl implements HelloService {
    private String asd ;
    @Override public String hello() {
        System.out.println("hello service world1！！");
        return "asd";
    }
}
