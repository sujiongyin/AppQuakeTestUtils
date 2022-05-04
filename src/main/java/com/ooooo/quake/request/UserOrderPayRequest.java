package com.ooooo.quake.request;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单支付相关查询请求参数
 */
@Data
public class UserOrderPayRequest {
    /**
     * 主键
     */
    private String id;

    /**
     * 订单序列编号
     */
    private String orderNo;

}
