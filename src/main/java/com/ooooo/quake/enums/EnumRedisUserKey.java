package com.ooooo.quake.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumRedisUserKey {

    // App验证码
    APP_VERIFICATIONCODE("user_code_email:"),

    // 商户后台验证码
    MERCHANT_VERIFICATIONCODE("merchantPhone:"),

    USER_INFO("user_info:");

    private String key;

}
