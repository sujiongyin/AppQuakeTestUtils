package com.ooooo.quake.controller;

import com.ooooo.quake.dto.JsonData;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnePoundController {


    public JsonData updateLotteryDate(){
        return JsonData.buildSuccess();
    }
}
