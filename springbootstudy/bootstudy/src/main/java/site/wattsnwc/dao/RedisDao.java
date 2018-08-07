package site.wattsnwc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value);
    }
    @Cacheable("watts")
    public String getValue(String key){
        System.out.println("watts init!");
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }
}