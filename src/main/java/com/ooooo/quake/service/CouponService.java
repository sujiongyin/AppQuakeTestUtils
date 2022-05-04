package com.ooooo.quake.service;

import com.ooooo.quake.model.Coupon;

public interface CouponService {

    /**
     * 根据优惠券查询单条数据
     * @param couponId 优惠券id
     * @return 实例对象
     */
    Coupon queryById(String couponId);
    
    

    /**
     * 根据优惠券查询单条数据
     * @param couponId 优惠券id
     * @return 实例对象
     */
    Coupon queryByEffectiveId(String couponId);

    /**
     * 优惠券缓存信息
     * @param couponId 优惠券Id
     * @return 优惠券详情
     */
    Object couponRedisInfo(String couponId);

    /**
     * 获取用户优惠券信息
     * @param couponId
     * @param userId
     * @return
     */
    Object getUserCoupon(String couponId, String userId);

}
