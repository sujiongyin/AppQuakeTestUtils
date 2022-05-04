package com.ooooo.quake.service.impl;


import com.ooooo.quake.model.UserCoupon;
import com.ooooo.quake.service.UserCouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户持有优惠券表(TUserCoupon)表服务实现类
 *
 * @author Lambert
 * @since 2021-04-19 23:45:52
 */
@Slf4j
@Service("UserCouponService")
public class UserCouponServiceImpl implements UserCouponService {
    @Resource
    private com.ooooo.quake.dao.UserCouponDao UserCouponDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserCoupon queryById(String id) {
        return this.UserCouponDao.queryById(id);
    }

    /**
     * 通过优惠券ID查询用户数据
     *
     * @param couponId 主键
     * @return 实例对象
     */
    @Override
    public List<UserCoupon> queryCouponIdToCouponUserId(String couponId) {
        return UserCouponDao.queryCouponIdToCouponUserId(couponId, null);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserCoupon> queryAllByLimit(int offset, int limit) {
        return this.UserCouponDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param UserCoupon 实例对象
     * @return 实例对象
     */
    @Override
    public UserCoupon insert(UserCoupon UserCoupon) {
        this.UserCouponDao.insert(UserCoupon);
        return UserCoupon;
    }

    /**
     * 修改数据
     *
     * @param UserCoupon 实例对象
     * @return 实例对象
     */
    @Override
    public UserCoupon update(UserCoupon UserCoupon) {
        this.UserCouponDao.update(UserCoupon);
        return this.queryById(UserCoupon.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.UserCouponDao.deleteById(id) > 0;
    }
}
