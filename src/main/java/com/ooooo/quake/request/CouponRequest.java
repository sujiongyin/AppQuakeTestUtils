package com.ooooo.quake.request;

import lombok.Data;

@Data
public class CouponRequest {
    /**
     * 优惠券Id
     */
    private String couponId;

    /**
     * 原名字
     */
    private String originalName;

    /**
     * 现名字
     */
    private String nowTheName;
}
