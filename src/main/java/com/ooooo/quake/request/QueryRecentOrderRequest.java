package com.ooooo.quake.request;

import lombok.Data;

@Data
public class QueryRecentOrderRequest {
    int offset=0;
    int limit=20;
}
