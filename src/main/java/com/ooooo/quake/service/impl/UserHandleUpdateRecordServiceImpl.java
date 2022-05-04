package com.ooooo.quake.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.ooooo.quake.aspect.annotation.Log;
import com.ooooo.quake.dao.UserHandleUpdateRecordDao;
import com.ooooo.quake.model.UserHandleUpdateRecord;
import com.ooooo.quake.service.UserHandleUpdateRecordService;
import com.ooooo.quake.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户举报表(TUserHandleUpdateRecord)表服务实现类
 *
 * @author Lambert
 * @since 2021-07-28 22:31:34
 */
@Slf4j
@Service("UserHandleUpdateRecordService")
public class UserHandleUpdateRecordServiceImpl implements UserHandleUpdateRecordService {
    @Resource
    private UserHandleUpdateRecordDao userHandleUpdateRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserHandleUpdateRecord queryById(String id) {
        return this.userHandleUpdateRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserHandleUpdateRecord> queryAllByLimit(int offset, int limit) {
        return this.userHandleUpdateRecordDao.queryAllByLimit(offset, limit);
    }


    @Override
    public List<UserHandleUpdateRecord> queryHandelAllBy(UserHandleUpdateRecord tUserHandleUpdateRecord) {
        return this.userHandleUpdateRecordDao.queryAll(tUserHandleUpdateRecord);
    }


    /**
     * 新增数据
     *
     * @param tUserHandleUpdateRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserHandleUpdateRecord insert(UserHandleUpdateRecord tUserHandleUpdateRecord) {
        this.userHandleUpdateRecordDao.insert(tUserHandleUpdateRecord);
        return tUserHandleUpdateRecord;
    }

    /**
     * 修改数据
     *
     * @param tUserHandleUpdateRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserHandleUpdateRecord update(UserHandleUpdateRecord tUserHandleUpdateRecord) {
        this.userHandleUpdateRecordDao.update(tUserHandleUpdateRecord);
        return this.queryById(tUserHandleUpdateRecord.getId());
    }

    /**
     * 修改handel为两个月时间
     *
     * @param userHandleUpdateRecord
     * @return
     */
    @Override
    @Log
    public ArrayList<Object> updateHandeloperateTime(UserHandleUpdateRecord userHandleUpdateRecord) {
        // 查询全部返回时间
        List<UserHandleUpdateRecord> userHandleUpdateRecords = userHandleUpdateRecordDao.queryAll(userHandleUpdateRecord);

        ArrayList<Object> objects = new ArrayList<>();

        for (int i = 0; i < userHandleUpdateRecords.size(); i++) {
            String id = userHandleUpdateRecords.get(i).getId();
            String userId = userHandleUpdateRecords.get(i).getUserId();
            String handle = userHandleUpdateRecords.get(i).getHandle();
            Date operateTime = userHandleUpdateRecords.get(i).getOperateTime();
            DateTime date = DateUtil.date();
            // 获取前两个月操作时间
            Date twomonthsbeforeTime = RandomUtils.getTwomonthsbeforeTime(date);
            // 讲操作时间替换为前两个月时间
            userHandleUpdateRecord.setOperateTime(twomonthsbeforeTime);

            log.info("updateHandeloperateTime方法要更新的id是:{} ," +
                            "要更新的userId是:{} ," +
                            "要更新的handle是:{}" +
                            "要更新的operateTime时间是:{}" +
                            "当前时间为:{}" +
                            "两个月前的时间是:twomonthsbeforeTime:{}",
                    id, userId, handle, DateUtil.format(operateTime, "yyyy-MM-dd HH:mm:ss"), DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"), twomonthsbeforeTime);
            // 执行更新sql
            int i1 = userHandleUpdateRecordDao.updateByHandle(userHandleUpdateRecord);
            log.info("======tUserHandleUpdateRecord:{},  数量:{}" + userHandleUpdateRecord, i1);
            userHandleUpdateRecord = this.queryById(id);
            objects.add(userHandleUpdateRecord);
        }
        return objects;
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.userHandleUpdateRecordDao.deleteById(id) > 0;
    }
}
