package site.wattsnwc.java8.clojure;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

/**
 * 这里需要写注释
 */
public class CallClojure {

    static{
        IFn require =  Clojure.var("clojure.core","require");
        require.invoke(Clojure.read("clojure.data.codec.base64"));
    }

    public static void main(String[] args) {
        String msg = "wattsnwc";
        IFn baseEncodeF = Clojure.var("clojure.data.codec.base64","encode");
        byte[] b64EncodeBytes = (byte[]) baseEncodeF.invoke(msg.getBytes());
        System.out.println(new String(b64EncodeBytes));
    }
}
