package com.ooooo.quake.service;

import com.ooooo.quake.model.User;
import com.ooooo.quake.request.UserTokenRequest;
import com.ooooo.quake.responce.UserResponce;

import java.util.Map;

/**
 * @description:
 * @author: lizhen
 * @date: 2021/3/28 8:50 下午
 */
public interface UserService {

    /**
     * 获取App 验证码
     *
     * @param email 用户邮箱
     * @return 验证码
     */
    public String verificationCode(String email);

    /**
     * 发送验证码
     *
     * @param email 邮箱
     * @return true成功 false 失败
     */
    public boolean sendVerificationCode(String email);

    /**
     * 获取 商户后台 验证码
     *
     * @param email 用户邮箱
     * @return 验证码
     */
    public String MerchantVerificationCode(String email);

    /**
     * 用户是否存在
     *
     * @param email 邮箱
     * @return 是否存在
     */
    public boolean EmailRegistrationExist(String email);

    /**
     * 根据邮箱查询userId
     *
     * @param user 邮箱
     * @return 用户Id
     */
    public UserResponce emailToUserId(User user);


    /**
     * 快速注册接口
     *
     * @param user 邮箱，密码
     * @return 用户详细信息
     */
    public Object registerQuick(User user);

    /**
     * 随机推荐注册用户
     *
     * @return 用户详细信息
     */
    public Object RandomlyRecommendUsers();

    /**
     * 获取UserId用户详情
     *
     * @param userId 用户Id
     * @return userInfo 用户详情
     */
    Map<Object, Object> userIdByInfo(String userId);

    /**
     * 更改用户密码
     *
     * @param userId 用户id
     * @return 密码
     */
    String updatePassword(String userId);

    /**
     * 随机生成用户密码
     *
     * @param userId 用户Id
     * @return 密码
     */
    String randomPassword(String userId);


    /**
     * 根据email 获取用户Id
     *
     * @param email
     * @return
     */
    String emailToUserId(String email);

    /**
     * 快速注册
     * @param email email
     * @param num
     * @return
     */
    Map<Object, Object> quickRegistration(String email, int num);

    /**
     * 获取随机用户Id
     * @return
     */
    String getRandomUserId();

    /**
     * 获取随机用户token
     * @return
     */
    String getRandomUserToken();

    /**
     * 根据email获取token
     * @param email
     * @return
     */
    UserTokenRequest getEmailToken(UserTokenRequest userTokenRequest);

}
