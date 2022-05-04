package com.ooooo.quake.dao;

import com.ooooo.quake.model.UserCoupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户持有优惠券表(TUserCoupon)表数据库访问层
 *
 * @author Lambert
 * @since 2021-04-19 23:45:47
 */
@Service
public interface UserCouponDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserCoupon queryById(String id);

    /**
     * 通过优惠券ID查询用户Id数据
     *
     * @param couponId 主键 优惠券Id
     * @return userId
     */
    List<UserCoupon> queryCouponIdToCouponUserId(@Param("couponId") String couponId,@Param("userId") String userId);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserCoupon> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tUserCoupon 实例对象
     * @return 对象列表
     */
    List<UserCoupon> queryAll(UserCoupon tUserCoupon);

    /**
     * 新增数据
     *
     * @param tUserCoupon 实例对象
     * @return 影响行数
     */
    int insert(UserCoupon tUserCoupon);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserCoupon> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserCoupon> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserCoupon> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserCoupon> entities);

    /**
     * 修改数据
     *
     * @param tUserCoupon 实例对象
     * @return 影响行数
     */
    int update(UserCoupon tUserCoupon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

