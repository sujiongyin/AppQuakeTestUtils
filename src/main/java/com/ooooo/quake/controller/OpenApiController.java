package com.ooooo.quake.controller;

import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.responce.OpenAppAllResponce;
import com.ooooo.quake.service.OpenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/open-api/")
public class OpenApiController {

    @Autowired
    private OpenService openService;

    @ApiOperation("open-api 认证相关数据查询")
    @PostMapping(path = "/authentication/info")
    private Object OpenAuthentication(@RequestBody OpenAppAllResponce openAppAllResult){
        List<OpenAppAllResponce> openAppAllResults = openService.OpenAuthenticationAll(openAppAllResult);
        return JsonData.buildSuccess(openAppAllResults);
    }
}
