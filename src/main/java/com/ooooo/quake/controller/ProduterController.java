package com.ooooo.quake.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ProduterController {

    @GetMapping(path = "/test")
    public Object test(){
        int Random = (int)(Math.random()*100);
        return Random;
    }
}
