package com.ooooo.quake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanghao
 * @date 2020/3/4 3:46 下午
 * 店铺审核类型
 */
@AllArgsConstructor
@Getter
public enum EnumShopReviewType {
    UNKNOWN(-1),
    REG(0),
    CHANGEINFO(1);

    private Integer type;

    public static EnumShopReviewType valueOfType(int type){
        for (EnumShopReviewType reviewType : values()){
            if (reviewType.type == type){
                return reviewType;
            }
        }
        return UNKNOWN;
    }
}
