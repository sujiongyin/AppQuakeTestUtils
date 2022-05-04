package com.ooooo.quake.controller;

import com.kamo.market.user.iface.inter.AuthInterface;
import com.kamo.market.user.iface.inter.UserInterface;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.model.User;
import com.ooooo.quake.model.UserHandleUpdateRecord;
import com.ooooo.quake.request.UserTokenRequest;
import com.ooooo.quake.service.UserHandleUpdateRecordService;
import com.ooooo.quake.service.UserService;
import com.ooooo.quake.utils.RandomUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户信息表 前端控制器
 *
 * @author Lambert
 * @since 2021-03-29
 */
@Api(tags = "用户相关接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @DubboReference(check = false)
    private AuthInterface authService;

    @DubboReference(check = false)
    private UserInterface userInterface;


    @Autowired
    private UserHandleUpdateRecordService userHandleUpdateRecordService;

    /**
     * 获取App验证码
     *
     * @param user 邮箱
     * @return 验证码
     */
    @ApiOperation("App验证码")
    @RequestMapping(path = "/app/verificationCode", method = RequestMethod.POST)
    public JsonData verificationCode(@RequestBody User user) {
        final String verificationCode = userService.verificationCode(user.getEmail());
        return JsonData.buildSuccess(verificationCode);
    }

    /**
     * 邮箱发送验证码
     *
     * @param user 邮箱
     * @return 验证码
     */
    @ApiOperation("邮箱发送验证码")
    @RequestMapping(path = "/app/sendVerificationCode", method = RequestMethod.POST)
    public JsonData sendVerificationCode(@RequestBody User user) {
        return JsonData.buildSuccess(userService.sendVerificationCode(user.getEmail()));
    }

    /**
     * 获取商户后台验证码
     *
     * @param user 邮箱
     * @return 验证码
     */
    @ApiOperation("获取商户后台验证码")
    @RequestMapping(path = "/merchant/VerificationCode", method = RequestMethod.POST)
    public JsonData MerchantVerificationCode(@RequestBody User user) {
        return JsonData.buildSuccess(userService.MerchantVerificationCode(user.getEmail()));
    }

    @ApiOperation("判断邮箱是否存在")
    @RequestMapping(path = "/EmailRegistrationExist", method = RequestMethod.POST)
    public JsonData EmailRegistrationExist(@RequestBody User user) {
        return JsonData.buildSuccess(userService.EmailRegistrationExist(user.getEmail()));
    }


    @ApiOperation("根据邮箱获取UserId")
    @RequestMapping(path = "/emailToUserId", method = RequestMethod.POST)
    public JsonData emailToUserId(@RequestBody User user) {
        return JsonData.buildSuccess(userService.emailToUserId(user));
    }

    @ApiOperation("生成随机名字")
    @RequestMapping(path = "/randomName", method = RequestMethod.GET)
    public JsonData randomName() {
        return JsonData.buildSuccess(RandomUtils.randomEnglishName(8, 10));
    }


    @ApiOperation("根据用户Id查询用户详情")
    @RequestMapping(path = "/userIdByInfo", method = RequestMethod.POST)
    public JsonData userIdByInfo(@RequestBody User user) {
        return JsonData.buildSuccess(userService.userIdByInfo(user.getId()));
    }


    @ApiOperation("根据用户邮箱查询用户详情")
    @RequestMapping(path = "/emailByInfo", method = RequestMethod.POST)
    public JsonData emailByInfo(@RequestBody User user) {
        String userId = userService.emailToUserId(user.getEmail());
        Map<Object, Object> userInfo = userService.userIdByInfo(userId);
        return JsonData.buildSuccess(userInfo);
    }


    @ApiOperation("快速注册")
    @RequestMapping(path = "/quickRegistration", method = RequestMethod.POST)
    public JsonData quickRegistration(@RequestBody User user) {
        Map<Object, Object> userInfo = userService.quickRegistration(user.getEmail(), 10);
        return JsonData.buildSuccess(userInfo);
    }

    @ApiOperation("根据handle 查询记录表中全部记录")
    @RequestMapping(path = "/queryHandelAllBy", method = RequestMethod.POST)
    public JsonData queryHandelAllBy(@RequestBody UserHandleUpdateRecord userHandleUpdateRecord) {
        List<UserHandleUpdateRecord> userInfo = userHandleUpdateRecordService.queryHandelAllBy(userHandleUpdateRecord);
        return JsonData.buildSuccess(userInfo);
    }


    @ApiOperation("根据handle 查询记录表中全部记录")
    @RequestMapping(path = "/updateHandeloperateTime", method = RequestMethod.POST)
    public JsonData updateHandeloperateTime(@RequestBody UserHandleUpdateRecord userHandleUpdateRecord) {
        ArrayList<Object> objectArrayList = userHandleUpdateRecordService.updateHandeloperateTime(userHandleUpdateRecord);
        return JsonData.buildSuccess(objectArrayList);
    }

    @ApiOperation("获取随机用户Id")
    @RequestMapping(path = "/getRandomUserId", method = RequestMethod.GET)
    public JsonData getRandomUserId() {
        String randomUserId = userService.getRandomUserId();
        return JsonData.buildSuccess(randomUserId);
    }

    @ApiOperation("获取随机用户token")
    @RequestMapping(path = "/getRandomUserToken", method = RequestMethod.GET)
    public JsonData getRandomUserToken() {
        String randomUserToken = userService.getRandomUserToken();
        return JsonData.buildSuccess(randomUserToken);
    }

    @ApiOperation("获取指定用户token")
    @RequestMapping(path = "/getEmailToken", method = RequestMethod.POST)
    public JsonData getEmailToken(@RequestBody UserTokenRequest userTokenRequest) {
        UserTokenRequest emailToken = userService.getEmailToken(userTokenRequest);
        return JsonData.buildSuccess(emailToken);
    }

}

