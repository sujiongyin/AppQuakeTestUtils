package com.ooooo.quake.service;

import com.ooooo.quake.model.UserHandleUpdateRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户举报表(TUserHandleUpdateRecord)表服务接口
 *
 * @author Lambert
 * @since 2021-07-28 22:31:34
 */
public interface UserHandleUpdateRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserHandleUpdateRecord queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserHandleUpdateRecord> queryAllByLimit(int offset, int limit);

    /**
     * 根据Handle查询全部数据
     *
     * @param UserHandleUpdateRecord
     * @return
     */
    List<UserHandleUpdateRecord> queryHandelAllBy(UserHandleUpdateRecord UserHandleUpdateRecord);

    /**
     * 新增数据
     *
     * @param tUserHandleUpdateRecord 实例对象
     * @return 实例对象
     */
    UserHandleUpdateRecord insert(UserHandleUpdateRecord tUserHandleUpdateRecord);

    /**
     * 修改数据
     *
     * @param tUserHandleUpdateRecord 实例对象
     * @return 实例对象
     */
    UserHandleUpdateRecord update(UserHandleUpdateRecord tUserHandleUpdateRecord);

    /**
     * 修改时间
     * @param
     * @return
     */
    ArrayList<Object> updateHandeloperateTime(UserHandleUpdateRecord tUserHandleUpdateRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
