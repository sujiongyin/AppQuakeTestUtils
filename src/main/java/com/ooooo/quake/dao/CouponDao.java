package com.ooooo.quake.dao;

import com.ooooo.quake.model.Coupon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CouponDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Coupon queryById(String id);

    /**
     * 通过ID查询单条有效数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Coupon queryByEffectiveId(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Coupon> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param Coupon 实例对象
     * @return 对象列表
     */
    List<Coupon> queryAll(Coupon Coupon);

    /**
     * 新增数据
     *
     * @param Coupon 实例对象
     * @return 影响行数
     */
    int insert(Coupon Coupon);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCoupon> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Coupon> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCoupon> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Coupon> entities);

    /**
     * 修改数据
     *
     * @param Coupon 实例对象
     * @return 影响行数
     */
    int update(Coupon Coupon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);
}
