package site.wattsnwc.java8.lambda;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    void handle();
    default void run() {
        System.out.println("run");
    }
}