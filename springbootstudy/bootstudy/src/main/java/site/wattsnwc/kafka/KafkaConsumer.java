package site.wattsnwc.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
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
    @KafkaListener(topics = {"new1"})
    public void consumer(HashMap<String, Object> message) {
        System.out.println("test topic message : " + message.get("a"));
    }

//    @KafkaListener(topics = {"new2"}, group = "myname")
//    public void consumer(TestMsg message) {
//        System.out.println("test topic message name: " + message.getName());
//    }

    @KafkaListener(topics = {"new3"})
    public void consumer(String message) {
        System.out.println("test topic message str : " + message);
    }
}