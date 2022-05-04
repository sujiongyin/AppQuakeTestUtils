package com.ooooo.quake.controller;

import com.ooooo.quake.responce.CouponResponce;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.model.UserCoupon;
import com.ooooo.quake.service.UserCouponService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户持有优惠券表(TUserCoupon)表控制层
 *
 * @author Lambert
 * @since 2021-04-19 23:45:54
 */
@RestController
@RequestMapping("/UserCoupon")
public class UserCouponController {
    /**
     * 服务对象
     */
    @Resource
    private UserCouponService UserCouponService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public UserCoupon selectOne(String id) {
        return UserCouponService.queryById(id);
    }

    /**
     * 根据优惠券Id查询数据库UserId数据
     * @param couponResult 优惠券Id
     * @return
     */
    @PostMapping("/queryCouponIdToCouponUserId")
    public JsonData queryCouponIdToCouponUserId(@RequestBody CouponResponce couponResult){
        List<UserCoupon> userCoupon = UserCouponService.queryCouponIdToCouponUserId(couponResult.getCouponId());
        return JsonData.buildSuccess(userCoupon);
    }

}
