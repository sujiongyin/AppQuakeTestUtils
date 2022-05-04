package com.ooooo.quake.service;

import com.ooooo.quake.model.UserLottery;

import java.util.List;

/**
 * (TUserLottery)表服务接口
 *
 * @author Lambert
 * @since 2021-04-20 15:40:42
 */
public interface UserLotteryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLottery queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserLottery> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tUserLottery 实例对象
     * @return 实例对象
     */
    UserLottery insert(UserLottery tUserLottery);

    /**
     * 修改数据
     *
     * @param tUserLottery 实例对象
     * @return 实例对象
     */
    UserLottery update(UserLottery tUserLottery);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
