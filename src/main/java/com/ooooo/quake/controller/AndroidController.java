package com.ooooo.quake.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.request.AndroidRequest;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@Slf4j
public class AndroidController {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://127.0.0.1:5001/android/apk/info";

    /**
     * 获取AndroidApk详情
     * @param androidRequest
     * @return
     * @throws IOException
     */
    @ApiOperation("查询AndroidApk的详情")
    @RequestMapping(path = "/android/apk/info")
    public JsonData getAndroidApkInfo(@RequestBody AndroidRequest androidRequest) throws IOException {
        String result = restTemplate.postForObject(url, androidRequest, String.class);
        JsonNode jsonNode = objectMapper.reader().readTree(result);
        log.info("请求go获取S3数据返回:{}", jsonNode);
        JsonNode data = jsonNode.get("data");
        return JsonData.buildSuccess(data);
    }
}
