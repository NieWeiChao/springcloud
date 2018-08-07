package site.wattsnwc.java8.defaultmethod;

public interface IDonkey{
    default void run() {
        System.out.println("IDonkey run");
    }
}