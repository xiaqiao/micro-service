package cn.x.microservice.order.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xqa
 * @since 2021/3/26
 */
@Slf4j
@SuppressWarnings("all")
public class MybatisRedisCache implements Cache {

    private RedisTemplate<String, Object> redisTemplate;

    private final String id;

    // 读写锁
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public MybatisRedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (redisTemplate == null) {
            redisTemplate = getRedisTemplate();
        }
        redisTemplate.opsForValue().set(key.toString(), value, 10, TimeUnit.SECONDS);
    }

    @Override
    public Object getObject(Object key) {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate<String, Object>) AppUtil.getBean("redisTemplate");
        }
        return redisTemplate.opsForValue().get(key.toString());
    }

    @Override
    public Object removeObject(Object key) {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate<String, Object>) AppUtil.getBean("redisTemplate");
        }
        return redisTemplate.delete(key.toString());
    }

    @Override
    public void clear() {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate<String, Object>) AppUtil.getBean("redisTemplate");
        }
        Set<String> keys = redisTemplate.keys("*:" + this.id + "*");
        if (!CollectionUtils.isEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }

    @Override
    public int getSize() {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate<String, Object>) AppUtil.getBean("redisTemplate");
        }
        Long size = redisTemplate.execute(RedisServerCommands::dbSize);
        return size == null ? 0 : size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate<String, Object>) AppUtil.getBean("redisTemplate");
        }
        return redisTemplate;
    }
}
