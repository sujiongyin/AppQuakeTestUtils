package com.ooooo.quake.enums;


import java.util.Arrays;
import java.util.Objects;

public enum EnumProductBrandAuditStatus {

    UN_KNOW(-999, "未知"),

    TO_BE_AUDITED(1, "待审核"),

    AUDIT_PASS(2, "审核通过"),
    
    AUDIT_FAILED(3, "审核不过");

    private final Integer type;

    private final String desc;

    EnumProductBrandAuditStatus(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static EnumProductBrandAuditStatus parse(Integer type) {
        if (Objects.isNull(type)) {
            return UN_KNOW;
        }

        return Arrays.stream(EnumProductBrandAuditStatus.values())
                .filter(enumRole->Objects.equals(type, enumRole.getType()))
                .findFirst()
                .orElse(UN_KNOW);
    }
}
