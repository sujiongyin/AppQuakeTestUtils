package com.ooooo.quake.enums;


import java.util.Arrays;
import java.util.Objects;

public enum EnumProductAuditStatus {

    UN_KNOW(-999, "未知"),

    NEW_TO_BE_AUDITED(1, "新商品待审核"),

    NEW_AUDIT_FAIL(2, "新商品未过审"),
    
    NEW_AUDIT_ACCESS(3, "新商品审核通过"),
    
    OLD_TO_BE_AUDITED(4, "老商品待审核"),

    OLD_AUDIT_FAIL(5, "老商品未过审"),
    
    OLD_AUDIT_ACEESS(6, "老商品审核通过"),
    
    ;

    private final Integer type;

    private final String desc;

    EnumProductAuditStatus(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static EnumProductAuditStatus parse(Integer type) {
        if (Objects.isNull(type)) {
            return UN_KNOW;
        }

        return Arrays.stream(EnumProductAuditStatus.values())
                .filter(enumRole->Objects.equals(type, enumRole.getType()))
                .findFirst()
                .orElse(UN_KNOW);
    }
}
