package com.ooooo.quake.dao;

import com.ooooo.quake.model.UserOrder;
import com.ooooo.quake.request.UserOrderPayRequest;
import org.apache.ibatis.annotations.Param;

/**
 * 订单相关dao层
 */
public interface UserOrderDao {

    /**
     * 查询订单详情
     * @param userOrderPayRequest
     * @return
     */
    UserOrder queryOrderInfo(UserOrderPayRequest userOrderPayRequest);

    /**
     * 查询最近20笔订单
     * @return
     */
    UserOrder queryRecentOrder(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 更改支付订单状态
     * @param userOrder
     * @return
     */
    int updatePayOrderState(UserOrder userOrder);

    /**
     * 更改订单的 TransactionId
     * @param userOrder
     * @return
     */
    int updateOrderTransactionId(UserOrder userOrder);

}
