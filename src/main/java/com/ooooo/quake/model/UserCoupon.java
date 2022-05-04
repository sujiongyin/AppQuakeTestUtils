package com.ooooo.quake.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户持有优惠券表(TUserCoupon)实体类
 *
 * @author Lambert
 * @since 2021-04-19 23:44:33
 */
@Data
@Builder
public class UserCoupon implements Serializable {

    private static final long serialVersionUID = 182462750587717965L;
    /**
     * id
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 来源id
     */
    private String sourceId;
    /**
     * 来源
     */
    private Integer sourceType;
    /**
     * 优惠券id
     */
    private String couponId;
    /**
     * 优惠券类型，1-平台券，2-店铺券，4-商品券
     */
    private Integer couponType;
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
     * 货币代码
     */
    private String currencyCode;
    /**
     * 店铺id
     */
    private String shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 可用商品id
     */
    private String productIdList;
    /**
     * 有效期起始时间
     */
    private Date validityStartTime;
    /**
     * 有效期结束时间
     */
    private Date validityEndTime;
    /**
     * 是否使用
     */
    private Object isUsed;
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

}
