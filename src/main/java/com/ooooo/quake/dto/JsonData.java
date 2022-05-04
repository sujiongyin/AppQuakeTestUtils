package com.ooooo.quake.dto;

import com.ooooo.quake.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class JsonData implements Serializable {
    private static final long serialVersionUID = 337701303491908050L;

    private Integer code; // 状态码 0 表示成功，1表示处理中，-1表示失败
    private Object data; // 数据
    private String msg;// 描述

    public JsonData() {
    }

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    // 成功，传入数据
    public static JsonData buildSuccess() {
        return new JsonData(0, null, null);
    }

    // 成功，传入数据
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, "操作成功");
    }

    // 失败，传入描述信息
    public static JsonData buildError(ErrorCode errorCode) {
        return new JsonData(errorCode.getCode(), null, errorCode.getMsg());
    }


    public static JsonData buildError(ErrorCode errorCode,String msg) {
        return new JsonData(errorCode.getCode(), msg, errorCode.getMsg());
    }


}
