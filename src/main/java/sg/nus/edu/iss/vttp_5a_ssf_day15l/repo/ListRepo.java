package sg.nus.edu.iss.vttp_5a_ssf_day15l.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp_5a_ssf_day15l.util.Utility;

@Repository
public class ListRepo {
    @Autowired
    @Qualifier(Utility.TEMPLATE02)
    RedisTemplate<String, Object> template;
    
    public void leftPush(String key, String value){
        template.opsForList().leftPush(key, value);
    }

    public void rightPush(String key, String value){
        template.opsForList().rightPush(key, value);
    }

    public void leftPop(String key){
        template.opsForList().leftPop(key, 1);
    }

    public void rightPop(String key){
        template.opsForList().rightPop(key, 1);
    }

    public String get(String key, Integer index){
        return template.opsForList().index(key, index).toString();
    }

    public long size(String key){
        return template.opsForList().size(key);
    }

    public List<Object> getList(String key){
        List<Object> list = template.opsForList().range(key, 0, -1);
        return list;
    }

    public boolean deleteItem(String key, String valueToDelete){
        boolean isDeleted = false;

        long iFound = template.opsForList().indexOf(key, valueToDelete);

        if(iFound >=0){
            template.opsForList().remove(key, iFound, valueToDelete);
            isDeleted = !isDeleted;
        }

        return isDeleted;
    }
}
