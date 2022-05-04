package com.ooooo.quake.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 用户redis 封装
 */
@Component
public class RedisOrderUtils {

    @Autowired
    @Resource(name = "orderRedisTemplate")
    private StringRedisTemplate redisTpl; //jdbcTemplate

    /**
     * set 方法
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, String value) {
        try {
            redisTpl.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                redisTpl.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }


    /**
     * get 方法
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTpl.opsForValue().get(key);
    }

    //删除方法
    public void Del(String key) {
        redisTpl.delete(key);
    }

    /**
     * 指定缓存失效时间
     *
     * @param key  key的名字
     * @param time 缓存时效时间
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                // 设置缓存过期时间
                redisTpl.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key key 的名字不能为空
     * @return 时间(秒) 返回0代表为永久有效
     */
    public long getExpire(String key) {
        return redisTpl.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * redis里面存map
     *
     * @param name
     * @param field
     * @param value
     */
    public void HSetSet(String name, String field, Object value) {
        HashOperations<String, Object, Object> ops = redisTpl.opsForHash();
        ops.put(name, field, value);
    }

    /**
     * 获取map对象
     *
     * @param name
     * @param field
     */
    public Object HSetGet(String name, String field) {
        HashOperations<String, Object, Object> ops = redisTpl.opsForHash();
        return ops.get(name, field);
    }

    /**
     * HashGet
     * @param key 键 不能为null
     * @param item 项 不能为null
     * @return值
     */
    public Object hget(String key, String item) {
        return redisTpl.opsForHash().get(key, item);
    }

    /**
     * 检测redis 是否通
     *
     * @return
     */
    public Object ping() {
        return redisTpl.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }

}
