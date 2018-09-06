package site.wattsnwc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.wattsnwc.dao.RedisDao;
import site.wattsnwc.entity.TestC;
import site.wattsnwc.kafka.KafkaSender;

import java.util.Date;

@RestController
public class RedisController {
    @Autowired
    private RedisDao redisDao;
    @Autowired
    KafkaSender sender;
    @RequestMapping("/set")
    public String set(String key, String value) {
        redisDao.setKey(key, value);
        return "success";
    }

    @RequestMapping("/get")
    public TestC get(String key) {
        TestC c = new TestC();
        c.setDate(new Date());
        System.out.println(redisDao.getValue(key));
        return c;
    }
    @RequestMapping("/send")
    public void send() {
        sender.sendTest();
    }
}