package com.ooooo.quake.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LiveShowEmailRequest {
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 直播Id
     */
    private String liveId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 开始类型
     */
    private int startFromType;
}
