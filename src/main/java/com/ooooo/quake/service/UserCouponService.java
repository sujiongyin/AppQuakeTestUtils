package com.ooooo.quake.service;

import com.ooooo.quake.model.UserCoupon;

import java.util.List;

/**
 * 用户持有优惠券表(TUserCoupon)表服务接口
 *
 * @author Lambert
 * @since 2021-04-19 23:45:50
 */
public interface UserCouponService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserCoupon queryById(String id);

    /**
     * 通过ID查询单条数据
     *
     * @param couponId 优惠券Id
     * @return 实例对象
     */
    List<UserCoupon> queryCouponIdToCouponUserId(String couponId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserCoupon> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tUserCoupon 实例对象
     * @return 实例对象
     */
    UserCoupon insert(UserCoupon tUserCoupon);

    /**
     * 修改数据
     *
     * @param tUserCoupon 实例对象
     * @return 实例对象
     */
    UserCoupon update(UserCoupon tUserCoupon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
