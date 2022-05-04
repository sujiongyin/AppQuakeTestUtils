package com.ooooo.quake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumRedisCouponKey {

    /**
     * 优惠券详情
     */
    COUPON_INFO("coupon_info:");

    public String key;

}
