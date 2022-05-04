package com.ooooo.quake.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.model.Produter;
import com.ooooo.quake.service.ProduterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProduterService produterService;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/skuId/skuIdTo")
    public JsonData skuIdToOfferId(@RequestBody Produter produter){
        String skuId = produterService.skuIdToOfferId(produter.getSkuId()).getSkuId();
        return JsonData.buildSuccess(skuId);
    }
}
