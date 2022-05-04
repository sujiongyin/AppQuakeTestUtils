package com.ooooo.quake.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ooooo.quake.model.User;
import com.ooooo.quake.responce.UserResponce;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: lizhen
 * @date: 2021/3/29 1:19 上午
 */
@Service
public interface UserDao extends BaseMapper<User> {

    /**
     * 查看邮箱是否存在
     *
     * @param email 邮箱
     * @return
     */
    String EmailRegistrationExist(@Param("email") String email);

    /**
     * 根据邮箱查询UserId
     *
     * @param email 邮箱
     * @return 用户id
     */
    UserResponce emailToUserId(@Param("email") String email);

    /**
     * 根据Id获取全部信息
     * @param id
     * @return 全部信息
     */
    User idByInfo(@Param("id") String id);

    /**
     * 获取随机用户Id
     * @return
     */
    String getRandomUserId();

}
