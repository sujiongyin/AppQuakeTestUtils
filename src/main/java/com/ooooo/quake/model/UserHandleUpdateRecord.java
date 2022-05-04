package com.ooooo.quake.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户举报表(TUserHandleUpdateRecord)实体类
 *
 * @author Lambert
 * @since 2021-07-28 22:31:26
 */
@Data
@Builder
public class UserHandleUpdateRecord implements Serializable {
    private static final long serialVersionUID = 757492859961999047L;
    /**
     * 本id
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 拉黑者id
     */
    private String handle;
    /**
     * 是否删除
     */
    private Object isDelete;
    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
