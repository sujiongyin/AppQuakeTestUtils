package com.ooooo.quake.service.impl;

import com.ooooo.quake.dao.UserLotteryDao;
import com.ooooo.quake.model.UserLottery;
import com.ooooo.quake.service.UserLotteryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUserLottery)表服务实现类
 *
 * @author Lambert
 * @since 2021-04-20 15:40:42
 */
@Service("UserLotteryService")
public class UserLotteryServiceImpl implements UserLotteryService {
    @Resource
    private UserLotteryDao UserLotteryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserLottery queryById(String id) {
        return this.UserLotteryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserLottery> queryAllByLimit(int offset, int limit) {
        return this.UserLotteryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param UserLottery 实例对象
     * @return 实例对象
     */
    @Override
    public UserLottery insert(UserLottery UserLottery) {
        this.UserLotteryDao.insert(UserLottery);
        return UserLottery;
    }

    /**
     * 修改数据
     *
     * @param tUserLottery 实例对象
     * @return 实例对象
     */
    @Override
    public UserLottery update(UserLottery tUserLottery) {
        this.UserLotteryDao.update(tUserLottery);
        return this.queryById(tUserLottery.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.UserLotteryDao.deleteById(id) > 0;
    }
}
