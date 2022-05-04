package com.ooooo.quake.service.impl;

import com.ooooo.quake.dao.CouponDao;
import com.ooooo.quake.dao.UserCouponDao;
import com.ooooo.quake.model.Coupon;
import com.ooooo.quake.model.UserCoupon;
import com.ooooo.quake.enums.EnumRedisCouponKey;
import com.ooooo.quake.service.CouponService;
import com.ooooo.quake.utils.RedisOrderUtils;
import com.ooooo.quake.utils.RedisUserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao couponDao;

    @Autowired
    private UserCouponDao userCouponDao;

    @Autowired
    private RedisOrderUtils redisOrderUtils;

    @Autowired
    private RedisUserUtils redisUserUtils;


    /**
     * 根据优惠券查询单条数据
     *
     * @param couponId 优惠券id
     * @return 实例对象
     */
    @Override
    public Coupon queryById(String couponId) {
        return couponDao.queryById(couponId);
    }


    /**
     * 根据优惠券查询单条数据
     *
     * @param couponId 优惠券id
     * @return 实例对象
     */
    @Override
    public Coupon queryByEffectiveId(String couponId) {
        return couponDao.queryByEffectiveId(couponId);
    }

    /**
     * 优惠券缓存信息
     *
     * @param couponId 优惠券Id
     * @return 优惠券详情
     */
    @Override
    public Object couponRedisInfo(String couponId) {
        log.info("couponRedisInfo:" + EnumRedisCouponKey.COUPON_INFO + couponId, "info");
        return redisOrderUtils.hget(EnumRedisCouponKey.COUPON_INFO + couponId, "info");
    }

    /**
     * 获取用户优惠券
     *
     * @param couponId 优惠券Id
     * @param userId   用户Id
     * @return 详情
     */
    @Override
    public Object getUserCoupon(String couponId, String userId) {
        Map<Object, Object> hgetall = redisUserUtils.hgetall("userCoupon:" + userId);
//        redisUserUtils.hset("couponName")
        List<UserCoupon> userCoupons = userCouponDao.queryCouponIdToCouponUserId(couponId, userId);

        log.info("userCoupons:" + userCoupons.toString());
        return hgetall;
    }


}
