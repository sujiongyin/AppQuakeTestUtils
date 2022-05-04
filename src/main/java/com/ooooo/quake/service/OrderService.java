package com.ooooo.quake.service;

import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.model.UserOrder;
import com.ooooo.quake.request.UserOrderPayRequest;

public interface OrderService {

    /**
     * 查询订单详情
     * @param userOrderPayRequest
     * @return
     */
    UserOrder queryOrderInfo(UserOrderPayRequest userOrderPayRequest);

    /**
     * 更改支付状态
     * @param userOrderPayRequest
     * @return
     */
    JsonData updatePayOrderState(UserOrderPayRequest userOrderPayRequest);

    UserOrder queryRecentOrder(int offset, int limit);
}
