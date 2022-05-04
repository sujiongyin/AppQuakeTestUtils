package com.ooooo.quake.controller;

import cn.hutool.core.util.StrUtil;
import com.kamo.market.video.iface.bean.request.live.LiveShowRequest;
import com.kamo.market.video.iface.inter.LiveShowInterface;
import com.ooooo.quake.aspect.annotation.Log;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.exception.ErrorCode;
import com.ooooo.quake.request.LiveShowEmailRequest;
import com.ooooo.quake.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "/live")
public class LiveController {
    @DubboReference(check = false)
    LiveShowInterface liveShowInterface;

    @Autowired
    private UserService userService;

    @Log
    @RequestMapping(value = "/emailToStudio", method = RequestMethod.POST)
    public JsonData emailToStudio(@RequestBody LiveShowEmailRequest liveShowEmailRequest) {
        String email = liveShowEmailRequest.getEmail();
        LiveShowRequest liveShowRequest = new LiveShowRequest();
        if (!StrUtil.isBlankIfStr(email) || !StrUtil.hasBlank(email)) {
            String userId = userService.emailToUserId(email);
            log.info("当前用户email是:{} userId是:", email, userId);
            String liveId = liveShowEmailRequest.getLiveId();
            liveShowRequest.setLiveId(liveId);
            liveShowRequest.setUserId(userId);
            log.info("emailToStudio 有userId方法请求参数是:{}", liveShowRequest);
            return JsonData.buildSuccess(liveShowInterface.getLiveDetailForAudience(liveShowRequest));
        } else {
            String liveId = liveShowEmailRequest.getLiveId();
            liveShowRequest.setLiveId(liveId);
            log.info("emailToStudio 没有userId方法请求参数是:{}", liveShowRequest);
            return JsonData.buildSuccess(liveShowInterface.getLiveDetailForAudience(liveShowRequest));
        }
    }


    @Log
    @RequestMapping(value = "/randomUserToStudio", method = RequestMethod.POST)
    public JsonData randomUserToStudio(@RequestBody LiveShowRequest liveShowRequest) {
        String userId = userService.getRandomUserId();
        String liveId = liveShowRequest.getLiveId();
        if (StrUtil.hasBlank(liveId) && StrUtil.isBlank(liveId)) {
            return JsonData.buildError(ErrorCode.PARAMETER_IS_EMPTY);
        }
        liveShowRequest.setLiveId(liveId);
        liveShowRequest.setUserId(userId);
        log.info("emailToStudio 有userId方法请求参数是:{}", liveShowRequest);
        return JsonData.buildSuccess(liveShowInterface.getLiveDetailForAudience(liveShowRequest));
    }

}
