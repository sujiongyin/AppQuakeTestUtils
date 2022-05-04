package com.ooooo.quake.responce;

import lombok.Data;

import java.io.Serializable;

@Data
public class CouponResponce implements Serializable {

//    @JsonProperty("couponId")
    private String id;


    private String couponId;

    private String userId;
}
