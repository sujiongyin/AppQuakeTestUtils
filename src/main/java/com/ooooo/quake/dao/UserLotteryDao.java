package com.ooooo.quake.dao;

import com.ooooo.quake.model.UserLottery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TUserLottery)表数据库访问层
 *
 * @author Lambert
 * @since 2021-04-20 15:40:39
 */
public interface UserLotteryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLottery queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserLottery> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param UserLottery 实例对象
     * @return 对象列表
     */
    List<UserLottery> queryAll(UserLottery UserLottery);

    /**
     * 新增数据
     *
     * @param UserLottery 实例对象
     * @return 影响行数
     */
    int insert(UserLottery UserLottery);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserLottery> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserLottery> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserLottery> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserLottery> entities);

    /**
     * 修改数据
     *
     * @param UserLottery 实例对象
     * @return 影响行数
     */
    int update(UserLottery UserLottery);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

}

