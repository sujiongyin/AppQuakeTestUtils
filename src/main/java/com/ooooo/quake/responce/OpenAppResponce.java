package com.ooooo.quake.responce;

import lombok.Data;

import java.util.Date;

@Data
public class OpenAppResponce {
    /**
     * 主键id
     */
    private String id;

    /**
     * AppID
     */
    private String name;

    /**
     * 状态
     */
    private String status;

    /**
     * App的key
     */
    private String app_key;

    /**
     * 延签
     */
    private String app_secret;

    /**
     * 范围
     */
    private String scope;

    /**
     * url
     */
    private String url;

    /**
     * 回调地址(当前没用)
     */
    private String callback_url;

    /**
     * 用户id
     */
    private String user_id;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新时间
     */
    private Date update_time;

//    private String user_id;
//    private String access_token;
//    private String expires;
}
