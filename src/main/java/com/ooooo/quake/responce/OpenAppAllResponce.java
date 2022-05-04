package com.ooooo.quake.responce;

import lombok.Data;

import java.util.Date;

@Data
public class OpenAppAllResponce {
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
    private String appKey;

    /**
     * 延签
     */
    private String appSecret;

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
    private String callbackUrl;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private String appId;

    private String accessToken;

    private String expires;

    private String email;

    private String shopId;

    private String shopName;

}
