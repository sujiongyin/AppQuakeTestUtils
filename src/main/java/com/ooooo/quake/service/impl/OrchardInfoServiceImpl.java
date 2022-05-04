package com.ooooo.quake.service.impl;

import com.ooooo.quake.dao.OrchardInfoDao;
import com.ooooo.quake.model.OrchardInfo;
import com.ooooo.quake.service.OrchardInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 果园信息表(TOrchardInfo)表服务实现类
 *
 * @author Lambert
 * @since 2021-08-05 16:23:17
 */
@Slf4j
@Service("OrchardInfoService")
public class OrchardInfoServiceImpl implements OrchardInfoService {

    @Resource
    private OrchardInfoDao orchardInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrchardInfo queryById(String id) {
        return this.orchardInfoDao.queryById(id);
    }

    /**
     * 根据userId查询详情
     * @param userId 用户Id
     * @return 对象信息
     */
    @Override
    public OrchardInfo queryByUserId(String userId) {
        OrchardInfo orchardInfo = orchardInfoDao.queryByUserId(userId);
        log.info("orchardInfo:{}",orchardInfo);
        return orchardInfo;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<OrchardInfo> queryAllByLimit(int offset, int limit) {
        return this.orchardInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param orchardInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrchardInfo insert(OrchardInfo orchardInfo) {
        this.orchardInfoDao.insert(orchardInfo);
        return orchardInfo;
    }

    /**
     * 修改数据
     *
     * @param tOrchardInfo 实例对象
     * @return 实例对象
     */
    @Override
    public OrchardInfo update(OrchardInfo orchardInfo) {
        this.orchardInfoDao.update(orchardInfo);
        return this.queryById(orchardInfo.getId());
    }

    @Override
    public OrchardInfo updateByUserId(OrchardInfo orchardInfo) {
        this.orchardInfoDao.updateByUserId(orchardInfo);
        return this.queryById(orchardInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.orchardInfoDao.deleteById(id) > 0;
    }
}
