package site.wattsnwc.vmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里需要写注释
 */
public class XmsTest {
    static List<Integer> list = new ArrayList<>();
    private static Integer M1 = 1024*1024;
    private Object o = new Object();

    public void ttt() throws InterruptedException {
        o.wait();
    }
    /**
     * -Xmx1000M -Xms1000M -Xmn300M   -XX:+PrintGC -XX:+PrintGCDetails
     *
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 0 ;i<200;i++) {
            list.add(M1);
        }
        new Thread(new Runnable() {
            @Override public void run() {
                while (true){

                }
            }
        },"watts").start();
    }
}
