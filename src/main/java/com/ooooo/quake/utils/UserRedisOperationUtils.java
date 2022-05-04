package com.ooooo.quake.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class UserRedisOperationUtils {

    @Autowired
    private RedisUserUtils redisUserUtils;

    /**
     * 判断redis key 是否存在
     * @param userId
     * @return
     */
    public boolean userTokenIsEmpty(String userId) {
        log.info("userTokenIsEmpty方法");
        Object token = redisUserUtils.hget("user_info:"+userId, "token");
        log.info("token:{}",token);
        if (token.toString().length() > 0) {
            return false;
        }
        return true;
    }


    /**
     * 获取token
     * @param userId
     * @return
     */
    public String getToken(String userId) {
        String token = redisUserUtils.hget("user_info:"+userId, "token").toString();
        return token;
    }
}
