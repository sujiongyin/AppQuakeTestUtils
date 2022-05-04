package com.ooooo.quake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumUserCreatorReviewStatus {

    TO_REVIRW(0, "待审核"),
    PASSED(1, "审核通过"),
    REJECTED(2, "审核拒绝");

    private Integer status;
    private String desc;

}
