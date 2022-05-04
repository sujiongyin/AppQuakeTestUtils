package com.ooooo.quake.dao;

import com.ooooo.quake.model.UserHandleUpdateRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户举报表(TUserHandleUpdateRecord)表数据库访问层
 *
 * @author Lambert
 * @since 2021-07-28 22:31:33
 */
public interface UserHandleUpdateRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserHandleUpdateRecord queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserHandleUpdateRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tUserHandleUpdateRecord 实例对象
     * @return 对象列表
     */
    List<UserHandleUpdateRecord> queryAll(UserHandleUpdateRecord userHandleUpdateRecord);

    /**
     * 新增数据
     *
     * @param tUserHandleUpdateRecord 实例对象
     * @return 影响行数
     */
    int insert(UserHandleUpdateRecord tUserHandleUpdateRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserHandleUpdateRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserHandleUpdateRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserHandleUpdateRecord> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserHandleUpdateRecord> entities);

    /**
     * 修改数据
     *
     * @param tUserHandleUpdateRecord 实例对象
     * @return 影响行数
     */
    int update(UserHandleUpdateRecord tUserHandleUpdateRecord);


    /**
     * 根据Handle 更改时间
     * @param tUserHandleUpdateRecord UserHandleUpdateRecord – 实例对象
     * @return 影响行数
     */
    int updateByHandle(UserHandleUpdateRecord tUserHandleUpdateRecord);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

