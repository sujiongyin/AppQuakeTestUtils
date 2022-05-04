package com.ooooo.quake.service;

import com.ooooo.quake.model.OrchardInfo;

import java.util.List;

/**
 * 果园信息表(TOrchardInfo)表服务接口
 *
 * @author Lambert
 * @since 2021-08-05 16:23:17
 */
public interface OrchardInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrchardInfo queryById(String id);

    /**
     * 根据userId查询详情
     * @param userId 用户Id
     * @return 实例对象
     */
    OrchardInfo queryByUserId(String userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<OrchardInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param orchardInfo 实例对象
     * @return 实例对象
     */
    OrchardInfo insert(OrchardInfo orchardInfo);

    /**
     * 修改数据
     *
     * @param tOrchardInfo 实例对象
     * @return 实例对象
     */
    OrchardInfo update(OrchardInfo tOrchardInfo);

    /**
     * 根据用户id更新数据
     * @param orchardInfo
     * @return 实体对象
     */
    OrchardInfo updateByUserId(OrchardInfo orchardInfo);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

}
