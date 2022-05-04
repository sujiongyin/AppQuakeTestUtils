package com.ooooo.quake.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Coupon implements Serializable {

    private static final long serialVersionUID = 375212141784004285L;
    /**
     * id
     */
    private String id;
    /**
     * 优惠券类型，1-平台券，2-店铺券，4-商品券
     */
    private Integer couponType;
    /**
     * 优惠券使用类型，1-满减券，2-立减券
     */
    private Integer couponUseType;
    /**
     * 优惠券名称
     */
    private String couponName;
    /**
     * 优惠券金额
     */
    private Double couponPrice;
    /**
     * 门槛
     */
    private Double couponThresholdPrice;
    /**
     * 发行量 -1：不限制
     */
    private Integer couponCirculation;
    /**
     * 已授权数量
     */
    private Integer couponTotal;
    /**
     * 店铺对应userId
     */
    private String userId;
    /**
     * 店铺id
     */
    private String shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 货币代码
     */
    private String currencyCode;
    /**
     * 用户限领数量，-1：不限制
     */
    private Integer userLimit;
    /**
     * 启禁用状态
     */
    private Object isDisabled;
    /**
     * 有效期起始时间
     */
    private Date validityStartTime;
    /**
     * 有效期结束时间
     */
    private Date validityEndTime;
    /**
     * 是否删除
     */
    private Object isDelete;

    private Date createTime;

    private Date updateTime;
    /**
     * 有效天数
     */
    private Integer period;
    /**
     * 优惠券有效期类型，1-固定日期，2-天数
     */
    private Integer couponPeriodType;
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品名
     */
    private String productName;
    /**
     * 商品封面
     */
    private String productCoverUrl;
    /**
     * 有效天数(单位秒)
     */
    private Integer periodSeconds;

}
