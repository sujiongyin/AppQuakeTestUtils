package com.ooooo.quake.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付交易表(TTransactionFlow)实体类
 *
 * @author lambert
 * @since 2021-12-11 10:23:02
 */
@Data
public class TransactionFlow implements Serializable {
    private static final long serialVersionUID = -81120415501651532L;

    /**
     * 内部唯一交易号
     */
    private String id;

    /**
     * 父交易记录id，支付交易为空，退款交易与支付交易的id关联
     */
    private String parentTransId;

    /**
     * 购买人/付款人，market-user-id
     */
    private String userId;

    /**
     * 涉及的内部商品/服务订单号
     */
    private String referOrderId;

    /**
     * 货币单位
     */
    private String currencyCode;

    /**
     * 涉及总金额，单位：分
     */
    private Long totalAmount;

    /**
     * 交易说明
     */
    private String transDesc;

    /**
     * 交易通道，1-safecharge，2-stripe，3-braintree，4-paypal
     */
    private Integer transChannel;

    /**
     * market内部支付状态，-1-INVALID, 1-PRE_ORDER，2-APPROVED，3-DECLINED，4-PENDING，5-ERROR
     */
    private Integer marketTransState;

    /**
     * 交易类型，1-付款，2-退款
     */
    private Integer transType;

    /**
     * market结算状态，-1-INVALID，1-SUBMITTED，2-SETTLING，3-SETTLEMENT_PENDING 4-SETTLED
     */
    private Integer marketSettlementState;

    /**
     * 外部支付id，交易的唯一流水号
     */
    private String externalTransId;

    /**
     * 外部交易的状态，根据支付渠道不同属性不同
     */
    private String externalTransState;

    /**
     * 根据不同渠道，额外信息不同，safecharge: {"request_id":"xxx","gateway_id":"xxx","auth_cod":"xxx"}
     */
    private Object externalExtra;

    /**
     * 外部错误原因
     */
    private Object externalErrorInfo;

    /**
     * 外部信息更新时间
     */
    private Object externalUpdateTime;

    /**
     * 创建时间
     */
    private Object createTime;

    /**
     * 更新时间
     */
    private Object updateTime;

    /**
     * 是否删除
     */
    private Object isDelete;

    /**
     * 备注
     */
    private Integer remark1;
}
