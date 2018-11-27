package site.wattsnwc.java8.simpleaop;

import java.lang.reflect.Method;

/**
 * 这里需要写注释
 */
public class BeforeAdvice implements Advice {
    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }
    @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        methodInvocation.invoke();
        System.out.println("v1 test change");
        System.out.println("devlop test change");
        Object o = method.invoke(bean, args);
        System.out.println("asdddd:"+o);
        methodInvocation.invoke();
        return o;
    }
}
