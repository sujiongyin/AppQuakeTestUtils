package com.ooooo.quake.service.impl;

import com.google.common.base.Strings;
import com.kamo.market.base.model.Result;
import com.kamo.market.user.iface.bean.auth.CheckVerificationCodeResponse;
import com.kamo.market.user.iface.bean.model.register.RegisterAccountModel;
import com.kamo.market.user.iface.inter.AuthInterface;
import com.kamo.market.user.iface.inter.UserInterface;
import com.ooooo.quake.aspect.annotation.Log;
import com.ooooo.quake.dao.UserDao;
import com.ooooo.quake.model.User;
import com.ooooo.quake.request.UserTokenRequest;
import com.ooooo.quake.responce.UserResponce;
import com.ooooo.quake.service.UserService;
import com.ooooo.quake.utils.RandomUtils;
import com.ooooo.quake.utils.RedisOrderUtils;
import com.ooooo.quake.utils.RedisUserUtils;
import com.ooooo.quake.utils.UserRedisOperationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description: 用户相关操作
 * @author: lizhen
 * @date: 2021/3/29 1:17 上午
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserService userService;

    @DubboReference(check = false)
    private AuthInterface authService;

    @DubboReference(check = false)
    private UserInterface userInterface;

    @Autowired
    private RedisUserUtils redisUserUtils;

    @Autowired
    private RedisOrderUtils redisOrderUtils;


    @Autowired
    private UserDao userDao;


    /**
     * 获取邮箱验证码
     *
     * @param email 用户邮箱
     * @return 验证码
     */
    @Override
    public String verificationCode(String email) {
        String verificationCode = redisUserUtils.get("user_code_email:" + email);
        log.info("要查询App验证码的email:{} , 验证码为:{} ", email, verificationCode);
        return verificationCode;
    }

    /**
     * 发送随机验证码
     *
     * @param email 邮箱
     * @return
     */
    @Override
    public boolean sendVerificationCode(String email) {
        return redisUserUtils.set("user_code_email:" + email, RandomUtils.getRandom(4), 3000L);
    }

    /**
     * 查询商户后台验证码
     *
     * @param email 用户邮箱
     * @return 验证码
     */
    @Log
    @Override
    public String MerchantVerificationCode(String email) {
        String MerchantVerificationCode = redisOrderUtils.get("merchantPhone:" + email);
        log.info("要查询的email是:{}  验证码是:{} ", email, MerchantVerificationCode);
        return MerchantVerificationCode;
    }

    /**
     * 查看用户是否存在
     *
     * @param email 邮箱
     * @return
     */
    @Override
    public boolean EmailRegistrationExist(String email) {
        String userId = userDao.EmailRegistrationExist(email);
        if (Strings.isNullOrEmpty(userId)) {
            return false;
        }
        return true;
    }

    /**
     * 根据Email 查询UserId
     *
     * @param user 邮箱
     * @return
     */
    @Override
    public UserResponce emailToUserId(User user) {
        log.info("输入的email是:{}", user.getEmail());
        UserResponce userId = userDao.emailToUserId(user.getEmail());
        log.info("emailToUserId 的userId 是{}", userId);
        if (userId != null) {
            return userId;
        }
        return userId;
    }

    @Override
    public Object registerQuick(User user) {
        return null;
    }

    @Override
    public Object RandomlyRecommendUsers() {
        return null;
    }

    /**
     * 获取redis 用户详情
     *
     * @param userId 用户Id
     * @return
     */
    @Override
    public Map<Object, Object> userIdByInfo(String userId) {
        Map<Object, Object> hgetall = redisUserUtils.hgetall("user_info:" + userId);
        return hgetall;
    }

    /**
     * 更新密码
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public String updatePassword(String userId) {
        return null;
    }

    @Override
    public String randomPassword(String userId) {
        return null;
    }

    /**
     * 根据email获取用户id
     *
     * @param email 邮箱
     * @return 用户Id
     */
    @Override
    public String emailToUserId(String email) {
        UserResponce userResult = userDao.emailToUserId(email);
        return userResult.getId();
    }

    /**
     * 快速注册
     *
     * @param email email 邮箱
     * @param num
     * @return
     */
    @Override
    public Map<Object, Object> quickRegistration(String email, int num) {

        // 是否注册
        boolean isRegistration = userService.EmailRegistrationExist(email);
        log.info("判断当前用户是否注册 isRegistration:{}", isRegistration);

        // 发送验证码
        Result<Boolean> booleanResult = authService.sendVerificationCode(email, 1);
        log.info("发送验证码,邮箱为:{}, 返回值为:{}", email, booleanResult);

        // 获取验证码
        Object code = userService.verificationCode(email);
        log.info("获取验证码,邮箱为:{},验证码为:{}", email, code);

        // 检查验证码是否有效
        Result<CheckVerificationCodeResponse> checkVerificationCodeResponseResult = authService.checkVerificationCode(email, code.toString());
        log.info("检查验证码是否有效,email 为:{} ,code: {} ,checkVerificationCodeResponseResult:{}", email, code.toString(), checkVerificationCodeResponseResult);

        // 签名
        Object signature = checkVerificationCodeResponseResult.getData().getSignature();
        log.info("signature:{}", signature);

        RegisterAccountModel deviceInfo = new RegisterAccountModel();

        // 设置邮箱
        deviceInfo.setEmail(email);

        // 设置密码
        deviceInfo.setPassword("Aa123456");

        // 设置签名
        deviceInfo.setSignature(signature.toString());

        // 设置userId
        deviceInfo.setInviteUserId("");

        /**
         * UN_KNOW(-999, "UN_KNOW", "未知"),
         * KOL(1, "kol_profile_invite", "kol"),
         * LUCK_BOX(2, "luckyBox", "lucky box"),
         */
        // 设置邀请源
        deviceInfo.setInviteSource("");

        // 邮箱注册
        authService.registerEmail(deviceInfo);

        // 截取email @ 之前的
        Object handle = StringUtils.substringBefore(email, "@");
        log.info("截取handle:{}", handle);

        // 获取 userId
        Object userId = userService.emailToUserId(email);
        log.info("userId :{}", userId);

        // 更新 Handle
        userInterface.updateUserHandle(userId.toString(), handle.toString());

        // 获取用户详情
        Map<Object, Object> userInfo = userService.userIdByInfo(email);
        log.info("redis的用户详情 userInfo:{}", userInfo);
        return userInfo;
    }

    /**
     * 获取随机用户Id
     *
     * @return
     */
    @Log
    @Override
    public String getRandomUserId() {
        String randomUserId = userDao.getRandomUserId();
        log.info("数据库查询出UserId:{}", randomUserId);
        return randomUserId;
    }

    @Override
    public String getRandomUserToken() {
        UserRedisOperationUtils userRedisOperationUtils = new UserRedisOperationUtils();
        String randomUserId = getRandomUserId();
        log.info("randomUserId:{}", randomUserId);
        boolean b = userRedisOperationUtils.userTokenIsEmpty(randomUserId);
        if (b) {
            String token = userRedisOperationUtils.getToken(randomUserId);
            log.info("判断b,randomUserId:{}, b:{},token:{}", randomUserId, b, token);
            return token;
        }
        log.info("判断b,randomUserId:{}, b:{}", randomUserId, b);
        return null;
    }

    /**
     * 根据email获取token
     *
     * @param userTokenRequest
     * @return
     */
    @Log
    @Override
    public UserTokenRequest getEmailToken(UserTokenRequest userTokenRequest) {
        String userId = emailToUserId(userTokenRequest.getEmail());
        log.info("用户Id为: {}",userId);
        Object token = redisUserUtils.hget("user_info:" + userId, "token");
        log.info("用户token: {}",token);
        userTokenRequest.setToken(token.toString());
        userTokenRequest.setUserId(userId);
        userTokenRequest.setEmail(userTokenRequest.getEmail());
        return userTokenRequest;
    }
}
