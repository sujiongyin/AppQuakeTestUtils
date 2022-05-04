package com.ooooo.quake.model;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 果园信息表(TOrchardInfo)实体类
 *
 * @author Lambert
 * @since 2021-08-05 16:23:15
 */
@Data
public class OrchardInfo implements Serializable {
    private static final long serialVersionUID = -57089991288890016L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 0.普通果树
     */
    private Integer treeType;
    /**
     * 0.无 1.小树枝 2.小树 3.大树 4.开花 5.果实 6.兑换
     */
    private Integer treeStatus;
    /**
     * 肥力值
     */
    private Integer fertilizerNum;
    /**
     * 水滴数量
     */
    private Integer waterNum;
    /**
     * 已浇水次数
     */
    private Integer waterCount;
    /**
     * 进度
     */
    private Integer progress;
    /**
     * 上次签到时间
     */
    private Date lastSignTime;
    /**
     * 连续签到天数
     */
    private Integer continueSignDay;
    /**
     * 小肥料数量
     */
    private Integer lnpkNum;
    /**
     * 大肥料数量
     */
    private Integer bnpkNum;
    /**
     * 是否删除
     */
    private Object isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
