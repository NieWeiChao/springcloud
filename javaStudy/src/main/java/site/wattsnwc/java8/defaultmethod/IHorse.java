package site.wattsnwc.java8.defaultmethod;

public interface IHorse {

    default void run(){
        System.out.println("Horse run");
    }

}