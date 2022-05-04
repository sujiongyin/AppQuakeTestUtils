package com.ooooo.quake.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * (TUserLottery)实体类
 *
 * @author Lambert
 * @since 2021-04-20 15:38:49
 */
@Data
@Builder
public class UserLottery implements Serializable {
    private static final long serialVersionUID = 264350335026581332L;

    /**
     * 主键Id
     */
    private String id;

    /**
     * 用户Id
     */
    private String userId;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 交易编号
     */
    private String transactionId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 抽奖时间
     */
    private Date lotteryDate;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 名字
     */
    private String firstName;

    /**
     * 姓氏
     */
    private String lastName;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 家庭地址
     */
    private String houseNo;

    /**
     * 住址
     */
    private String address;

    /**
     * 城市
     */
    private String city;

    /**
     * 省
     */
    private String province;

    /**
     * 邮政编码
     */
    private String zipCode;

    /**
     * 国家名字
     */
    private String countryName;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 移动国家代码
     */
    private String mobileCountryCode;

}
