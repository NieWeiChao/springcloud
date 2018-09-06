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
        Object o = method.invoke(bean, args);
        System.out.println("asd:"+o);
        methodInvocation.invoke();
        return o;
    }
}
