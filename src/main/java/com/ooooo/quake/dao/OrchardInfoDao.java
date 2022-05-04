package com.ooooo.quake.dao;

import com.ooooo.quake.model.OrchardInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 果园信息表(TOrchardInfo)表数据库访问层
 *
 * @author Lambert
 * @since 2021-08-05 16:23:17
 */
public interface OrchardInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrchardInfo queryById(String id);

    /**
     * 根据UserId查询详情
     *
     * @param userId
     * @return
     */
    OrchardInfo queryByUserId(String userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrchardInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tOrchardInfo 实例对象
     * @return 对象列表
     */
    List<OrchardInfo> queryAll(OrchardInfo tOrchardInfo);

    /**
     * 新增数据
     *
     * @param tOrchardInfo 实例对象
     * @return 影响行数
     */
    int insert(OrchardInfo tOrchardInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrchardInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<OrchardInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrchardInfo> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<OrchardInfo> entities);

    /**
     * 修改数据
     *
     * @param tOrchardInfo 实例对象
     * @return 影响行数
     */
    int update(OrchardInfo tOrchardInfo);

    /**
     * 根据userId修改用户数据
     *
     * @param orchardInfo
     * @return
     */
    int updateByUserId(OrchardInfo orchardInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

