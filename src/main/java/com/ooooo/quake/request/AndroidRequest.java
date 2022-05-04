package com.ooooo.quake.request;

import lombok.Data;

@Data
public class AndroidRequest {

    /**
     * 查询环境
     */
    private String env;

    /**
     * 查询时间
     */
    private String date;
}
