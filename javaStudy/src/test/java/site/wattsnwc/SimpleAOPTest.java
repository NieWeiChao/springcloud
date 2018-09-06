package site.wattsnwc;

import org.junit.Test;
import site.wattsnwc.java8.simpleaop.Advice;
import site.wattsnwc.java8.simpleaop.BeforeAdvice;
import site.wattsnwc.java8.simpleaop.HelloService;
import site.wattsnwc.java8.simpleaop.HelloServiceImpl;
import site.wattsnwc.java8.simpleaop.MethodInvocation;
import site.wattsnwc.java8.simpleaop.SimpleAOP;

import java.lang.reflect.Proxy;

public class SimpleAOPTest {
    @Test
    public void getProxy() throws Exception {
        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");

        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();
        
        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);
        
        // 3. 为目标对象生成代理
//        HelloService helloServiceImplProxy =
//                (HelloService) SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);
        HelloService helloServiceImplProxy = (HelloService) Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                helloServiceImpl.getClass().getInterfaces(), beforeAdvice);
        helloServiceImplProxy.hello();
    }
}