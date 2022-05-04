package com.ooooo.quake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumCouponTriggerCondition {
    UNKONW(-1, "未知"),
    NEW_USER(1, "新注册"),
    FIRST_ORDER(2, "完成第一笔订单"),
    SHARE_ORDER_VIDEO(3, "分享第一个晒单视频");

    private Integer type;
    private String desc;

    public static EnumCouponTriggerCondition valueOfType(Integer type){
        for (EnumCouponTriggerCondition range : values()){
            if (range.type.equals(type)){
                return range;
            }
        }
        return NEW_USER;
    }
}
