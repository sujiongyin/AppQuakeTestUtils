package com.ooooo.quake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumCouponRange {
    UNKONW(-1, "未知"),
    DEFAULT(1, "全场");

    private Integer type;
    private String desc;

    public static EnumCouponRange valueOfType(Integer type){
        for (EnumCouponRange range : values()){
            if (range.type.equals(type)){
                return range;
            }
        }
        return DEFAULT;
    }
}
