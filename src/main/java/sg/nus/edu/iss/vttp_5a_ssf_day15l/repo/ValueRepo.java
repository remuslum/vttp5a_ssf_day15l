package sg.nus.edu.iss.vttp_5a_ssf_day15l.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp_5a_ssf_day15l.util.Utility;

@Repository
public class ValueRepo {
    @Autowired
    @Qualifier(Utility.TEMPLATE01)
    RedisTemplate<String, String> template;

    public void createValue(String key, String value){
        template.opsForValue().set(key, value);
    }

    public String getValue(String key){
        return template.opsForValue().get(key);
    }

    public String deleteValue(String key){
        return template.opsForValue().getAndDelete(key);
    }

    public void incrementValue(String key){
        template.opsForValue().increment(key);
    }

    public void decrementValue(String key){
        template.opsForValue().decrement(key);
    }

    public void incrementValueBy(String key, Integer value){
        template.opsForValue().increment(key, value);
    }

    public void decrementValueBy(String key, Integer value){
        template.opsForValue().decrement(key, value);
    }

    public boolean checkExists(String key){
        return template.hasKey(key);
    }

}
