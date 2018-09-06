package site.wattsnwc.java8.defaultmethod;

public class DefaultMethodTest implements  IDonkey,IHorse {
    public static void main(String[] args) {
        DefaultMethodTest defaultMethod = new DefaultMethodTest();
        defaultMethod.run();
    }

    @Override public void run() {
        IHorse.super.run();
    }
}