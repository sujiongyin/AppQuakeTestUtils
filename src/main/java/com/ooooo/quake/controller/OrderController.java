package com.ooooo.quake.controller;

import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.model.UserOrder;
import com.ooooo.quake.request.QueryRecentOrderRequest;
import com.ooooo.quake.request.UserOrderPayRequest;
import com.ooooo.quake.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 查询订单详情
     * @param userOrderPayRequest
     * @return
     */
    @PostMapping(path = "queryOrderInfo")
    public JsonData queryOrderInfo(@RequestBody UserOrderPayRequest userOrderPayRequest){
        UserOrder userOrder = orderService.queryOrderInfo(userOrderPayRequest);
        return JsonData.buildSuccess(userOrder);
    }

    /**
     * 更改订单支付状态
     * @param userOrderPayRequest
     * @return
     */
    @PostMapping(path = "/updatePayOrderState")
    public JsonData updatePayOrderState(@RequestBody UserOrderPayRequest userOrderPayRequest){
        JsonData jsonData = orderService.updatePayOrderState(userOrderPayRequest);
        return jsonData;
    }

    @RequestMapping(path = "/queryRecentOrder")
    public JsonData queryRecentOrder(QueryRecentOrderRequest queryRecentOrderRequest){
        int offset = queryRecentOrderRequest.getOffset();
        int limit = queryRecentOrderRequest.getLimit();
        log.info("offset: {}  limit:{}",offset,limit);
        return JsonData.buildSuccess(orderService.queryRecentOrder(offset,limit));
    }

}
