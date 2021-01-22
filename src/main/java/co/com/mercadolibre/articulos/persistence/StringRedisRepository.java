package co.com.mercadolibre.articulos.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class StringRedisRepository {

    private final StringRedisTemplate template;

    public StringRedisRepository(StringRedisTemplate template) {
        this.template = template;
    }

    public void add(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public String getBy(String key) {
        return template.opsForValue().get(key);
    }

    public Set<String> getKeys(String patternKey) {
        return template.keys(patternKey);
    }

    public Set<String> getAllValuesBy(String patternKey) {
        final Set<String> keys = getKeys(patternKey);
        final Set<String> values = new HashSet<String>(keys.size());

        for (String key : keys) {
            values.add(getBy(key));
        }

        return values;
    }

    public void delete(String key) {
        template.opsForValue().getOperations().delete(key);
    }

    public boolean hput(String key, String hkey, Object value) {
        try {
            template.opsForHash().put(key, hkey, value);
            log.debug("hput {} = {}", key+hkey, value);
            return true;
        } catch (Exception e) {
            log.warn("hput {} = {}", key+hkey, value, e);
        }
        return false;
    }

    public boolean setPage(String key, String hkey, double score, String value){
        boolean result = false;
        try {
            template.opsForZSet().add(key+":page", hkey, score);
            result = hput(key, hkey, value);
            log.debug("setPage {}", key);
        } catch (Exception e) {
            log.warn("setPage {}", key, e);
        }
        return result;
    }

    public Set<String> getPage(String key, int offset, int count){
        Set<String> result = null;
        try {
            result = template.opsForZSet().rangeByScore(key+":page", 1, 100000, (offset-1)*count, count);
            log.debug("getPage {}", key);
        } catch (Exception e) {
            log.warn("getPage {}", key, e);
        }
        return result;
    }

    public Integer getSize(String key){
        Integer num = 0;
        try {
            Long size = template.opsForZSet().zCard(key+":page");
            log.debug("getSize {}", key);
            return size.intValue();
        } catch (Exception e) {
            log.warn("getSize {}", key, e);
        }
        return num;
    }

}
