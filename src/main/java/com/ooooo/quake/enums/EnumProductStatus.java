package com.ooooo.quake.enums;


import java.util.Arrays;
import java.util.Objects;

public enum EnumProductStatus {

    UN_KNOW(-999, "未知","unkown"),

    LOWER_SHELF(0, "下架","offSale"),

    UPPER_SHELF(1, "上架","onSale"),

    ;

    private final Integer type;

    private final String desc;

    private final String enDesc;

    EnumProductStatus(Integer type, String desc,String enDesc) {
        this.type = type;
        this.desc = desc;
        this.enDesc = enDesc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getEnDesc() {
        return enDesc;
    }
    public static EnumProductStatus parse(Integer type) {
        if (Objects.isNull(type)) {
            return UN_KNOW;
        }

        return Arrays.stream(EnumProductStatus.values())
                .filter(enumRole->Objects.equals(type, enumRole.getType()))
                .findFirst()
                .orElse(UN_KNOW);
    }
}
