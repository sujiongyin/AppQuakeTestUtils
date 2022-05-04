package com.ooooo.quake.controller;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamo.market.activity.beans.orchard.OrchardSelfInfo;
import com.kamo.market.activity.beans.watermelon.UpdateScoreReq;
import com.kamo.market.activity.iface.GameWatermelonService;
import com.kamo.market.activity.iface.OrchardInterface;
import com.kamo.market.base.model.Result;
import com.ooooo.quake.aspect.annotation.Log;
import com.ooooo.quake.model.OrchardInfo;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.model.User;
import com.ooooo.quake.service.OrchardInfoService;
import com.ooooo.quake.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(path = "/game")
public class GameController {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 服务对象
     */
    @Resource
    private OrchardInfoService orchardInfoService;

    /**
     * 用户相关服务对象
     */
    @Autowired
    private UserService userService;

    @DubboReference(check = false)
    private OrchardInterface orchardInterface;

    @DubboReference(check = false)
    private GameWatermelonService gameWatermelonService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Log
    @ApiOperation("根据果园Id查询数据")
    @GetMapping("selectOne")
    public JsonData selectOne(String id) {
        return JsonData.buildSuccess(this.orchardInfoService.queryById(id));
    }

    /**
     * 根据email 查询详情
     *
     * @param user 用户邮箱
     * @return 实例详情
     */
    @Log
    @ApiOperation("根据邮箱查询详情")
    @PostMapping("/orchard/emailToInfo")
    public JsonData emailOrchardInfo(@RequestBody User user) {
        String userId = userService.emailToUserId(user.getEmail());
        if (StrUtil.isEmpty(userId)) {
            JsonData.buildSuccess(user.getEmail() + "用户Id为空");
        }
        log.info("当前用户的userId为:{}", userId);
        return JsonData.buildSuccess(this.orchardInfoService.queryByUserId(userId));
    }

    /**
     * 根据UserId查询详情
     *
     * @param user 用户Id
     * @return 实例详情
     */
    @Log
    @ApiOperation("根据用户Id查询详情")
    @PostMapping("/orchard/userIdToInfo")
    public JsonData userIdOrchardInfo(@RequestBody User user) {
        if (StrUtil.isEmpty(user.getId())) {
            JsonData.buildSuccess(user.getEmail() + "用户Id为空");
        }
        log.info("当前用户的userId为:{}", user.getId());
        return JsonData.buildSuccess(this.orchardInfoService.queryByUserId(user.getId()));
    }


    /**
     * 根据邮箱更新水滴数量
     *
     * @param orchardInfo
     * @return 实体详情
     */
    @Log
    @ApiOperation("根据用户Id更新水")
    @PostMapping("/orchard/UpdateUserIdToWater")
    public JsonData UpdateUserIdToWater(@RequestBody OrchardInfo orchardInfo) {
        if (StrUtil.isEmpty(orchardInfo.getUserId())) {
            JsonData.buildSuccess(orchardInfo.getUserId() + "用户Id为空");
        }
        // 更新数据
        this.orchardInfoService.updateByUserId(orchardInfo);
        OrchardInfo info = orchardInfoService.queryByUserId(orchardInfo.getUserId());
        log.info("当前果园详情为:{}", info);
        log.info("当前用户的userId为:{}", orchardInfo.getUserId());
        return JsonData.buildSuccess(info);
    }

    /**
     * 获取果园信息
     *
     * @param user
     * @return
     */
    @Log
    @ApiOperation("获取果园信息")
    @PostMapping("/orchard/getEmailOrchardInfoSelf")
    public JsonData getEmailOrchardInfoSelf(@RequestBody User user) {
        String userId = userService.emailToUserId(user.getEmail());
        if (StrUtil.isEmpty(userId)) {
            JsonData.buildSuccess(userId + "用户Id为空");
        }
        Result<OrchardSelfInfo> orchardInfoSelf = orchardInterface.getOrchardInfoSelf(userId);
        return JsonData.buildSuccess(orchardInfoSelf);
    }


    /**
     * 果园签到
     *
     * @param user
     * @return
     */
    @Log
    @ApiOperation("果园签到")
    @PostMapping("/orchard/dailySignIn")
    public JsonData dailySignIn(@RequestBody User user) {
        String userId = userService.emailToUserId(user.getEmail());
        if (StrUtil.isEmpty(userId)) {
            JsonData.buildSuccess(userId + "用户Id为空");
        }
        Result<?> result = orchardInterface.dailySignIn(userId);
        return JsonData.buildSuccess(result);
    }

    /**
     * 果园浇水
     *
     * @param user
     * @return
     */
    @Log
    @ApiOperation("果园浇水")
    @PostMapping("/orchard/water")
    public JsonData water(@RequestBody User user) {
        String userId = userService.emailToUserId(user.getEmail());
        if (StrUtil.isEmpty(userId)) {
            JsonData.buildSuccess(userId + "用户Id为空");
        }
        Result<?> water = orchardInterface.water(userId);
        return JsonData.buildSuccess(water);
    }


    /**
     * 游戏上传分数
     * @param req
     * @return
     */
    @Log
    @ApiOperation("游戏上传分数")
    @PostMapping("/watermelon/updateScore")
    public JsonData gameWatermelonUpdateScore(@RequestBody UpdateScoreReq req){
        Result<?> result = gameWatermelonService.updateScore(req);
        return JsonData.buildSuccess(result);
    }

}
