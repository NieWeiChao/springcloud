package site.wattsnwc.kafka;

import java.util.HashMap;

//@Component
//@ConditionalOnProperty(name = "watts.kafka.enable", havingValue = "true")
public class KafkaConsumer {

    static {
        System.out.println("shifoukaiqi");
    }

    /**
     * 监听test主题,有消息就读取
     *
     * @param message
     */
//    @KafkaListener(topics = {"new1"}, groupId = "my")
    public void consumer(HashMap<String, Object> message) {
        System.out.println("test topic message : " + message.get("a"));
    }

//    @KafkaListener(topics = {"new2"}, groupId = "myname")
//    public void consumer(TestMsg message) {
//        System.out.println("test topic message name: " + message.getName());
//    }

    //    @KafkaListener(topics = {"new3"}, groupId = "mystr")
    public void consumer(String message) {
        System.out.println("test topic message str : " + message);
    }
}