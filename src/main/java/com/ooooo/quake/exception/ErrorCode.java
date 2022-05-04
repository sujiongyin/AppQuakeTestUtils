package com.ooooo.quake.exception;

public enum ErrorCode {
    //未知异常
    UNKONW_ERROR(500000, "未知异常"),
    //用户模块
    USER_REGIST_EXCEPTION(1000001, "用户注册异常"),

    PARAMETER_IS_EMPTY(1000002,"必传参数不能为空"),

    ORDER_STATUS_MUST_PAID(1000003,"您要更改的订单状态必须是待支付状态，订单状态为 1"),

    ORDER_NOT_EXIST(1000004,"您的订单数据为空,请检查您传入的订单id或订单号码");

    //游戏模块
    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
