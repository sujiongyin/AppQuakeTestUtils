package com.ooooo.quake.responce;

import lombok.Data;

import java.util.Date;

@Data
public class OpenAccessTokenResponce {
    /**
     * id
     */
    private String id;
    /**
     * AppId
     */
    private String app_id;
    /**
     * 用户id
     */
    private String user_id;
    /**
     * 访问令牌
     */
    private String access_token;
    /**
     * 范围
     */
    private String scope;
    /**
     * 过期
     */
    private String expires;
    /**
     * 状态
     */
    private String status;
    /**
     * 创建时间
     */
    private Date create_time;
    /**
     * 更新时间
     */
    private Date update_time;
}
