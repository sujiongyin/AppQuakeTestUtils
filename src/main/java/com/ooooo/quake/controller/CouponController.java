package com.ooooo.quake.controller;

import com.ooooo.quake.responce.CouponResponce;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.service.CouponService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/coupon")
@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;

    @ApiOperation("根据用户Id查询优惠券详情")
    @PostMapping(path = "/queryById")
    public JsonData queryById(@RequestBody CouponResponce couponResult){
        System.out.println("couponResult:"+couponResult.getCouponId());
        return JsonData.buildSuccess(couponService.queryById(couponResult.getCouponId()));
    }

    /**
     * 根据优惠券Id查询redis 数据详情
     * @param couponResult 优惠券Id
     * @return 缓存数据
     */
    @ApiOperation("根据用户Id查询redis信息")
    @PostMapping(path = "/couponRedisInfo")
    public JsonData couponRedisInfo(@RequestBody CouponResponce couponResult){
        return JsonData.buildSuccess(couponService.couponRedisInfo(couponResult.getCouponId()));
    }

    /**
     * 根据优惠券Id查询redis 数据详情
     * @param couponResult 优惠券Id
     * @return 缓存数据
     */
    @ApiOperation("根据用户Id查询redis信息")
    @PostMapping(path = "/getUserCoupon")
    public JsonData getUserCoupon(@RequestBody CouponResponce couponResult){
        return JsonData.buildSuccess(couponService.getUserCoupon(couponResult.getCouponId(),couponResult.getUserId()));
    }


    @PostMapping(path = "/updateCouponName")
    public JsonData updateCouponName(@RequestBody CouponResponce couponResult){

        return JsonData.buildSuccess();
    }
}
