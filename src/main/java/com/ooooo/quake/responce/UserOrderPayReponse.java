package com.ooooo.quake.responce;

import lombok.Data;

import java.util.Date;

@Data
public class UserOrderPayReponse {

    /**
     * 主键
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 订单序列编号
     */
    private String orderNo;

    /**
     * 买家id
     */
    private String userId;

    /**
     * 买家name
     */
    private String userName;

    /**
     * 买家phone
     */
    private String userPhone;

    /**
     * 订单总金额
     */
    private Double price;

    /**
     * 原始商品总金额
     */
    private Double initialPrice;

    /**
     * 优惠券总金额
     */
    private Double couponPrice;

    /**
     * 原始优惠券总金额
     */
    private Double initialCouponPrice;

    /**
     * 实际付款总金额
     */
    private Double paidPrice;

    /**
     * 原始实际付款总金额
     */
    private Double initialPaidPrice;

    /**
     * 实际付款总金额美元
     */
    private Double paidPriceUsd;

    /**
     * 运费金额
     */
    private Double shippingPrice;

    /**
     * 订单初始运费
     */
    private Double initialShippingPrice;

    /**
     * 运费金额美元
     */
    private Double shippingPriceUsd;

    /**
     * 商品总数量
     */
    private Integer productNum;

    private Integer initialProductNum;

    /**
     * 用户优惠劵ID
     */
    private String userCouponId;

    /**
     * 优惠劵ID
     */
    private String couponId;

    /**
     * 1-待付款,2-已支付/待确认,3-待发货,4-待收货,5-已收货,6-交易完成,7-交易关闭,8-已退款,9-退货,10-退货拒绝,11-退货成功,12-申诉,13-申诉成功,14-申诉失败,15-取消订单
     */
    private Integer orderState;

    /**
     * 店铺id
     */
    private String shopId;

    private String shopName;

    /**
     * 支付流水id
     */
    private String payId;

    /**
     * 支付类型,1:PayPal,2:BillingCard,3:stripe
     */
    private Object payType;

    /**
     * 订单渠道
     */
    private Integer orderChannel;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 该商品是否有佣金,true有,false没有, 0是没有,1是有
     */
    private Object haveCommission;

    /**
     * 佣金
     */
    private Double commission;

    /**
     * 平台分成
     */
    private Double platform;

    /**
     * 状态
     */
    private Object commissionState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 内部交易流水号
     */
    private String transactionId;

    /**
     * 货币code
     */
    private String currency;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 是否是虚拟库存
     */
    private Integer virtualStock;

    /**
     * 订单状态最后一次变更时间
     */
    private Date orderStatusChangeTime;

    /**
     * 闪购订单所属用户
     */
    private String localSellerUserId;
}
