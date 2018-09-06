package site.wattsnwc.kafka;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
//@ConditionalOnProperty(name = "watts.kafka.enable", havingValue = "true")
public class KafkaSender {
    private volatile int count = 0;
    @Autowired
    @SuppressWarnings("all")
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发送消息到kafka,主题为test
     */
    public void sendTest() {
        HashMap<String, Object> h = new HashMap<>();
        h.put("a", "a");
        String s = new JSONObject(h).toString();
        kafkaTemplate.send("new1", h);
//        kafkaTemplate.send("new2", TestMsg.newInstance("twattsname"));
        kafkaTemplate.send("new3", "asd123");
    }
}