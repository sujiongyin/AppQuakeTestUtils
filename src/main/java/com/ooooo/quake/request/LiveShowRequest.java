package com.ooooo.quake.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LiveShowRequest {
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
