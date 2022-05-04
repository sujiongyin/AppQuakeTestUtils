package com.ooooo.quake.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


public class ThirdPartyInterface {
    @Autowired
    private RestTemplate restTemplate;
    private static ObjectMapper objectMapper = new ObjectMapper();


    private static String url = "http://quake-test-api.o5brazil.com/user/userIdByInfo";
    public String userIdByInfo(String userId){
         String reqJson = "{\"userId\":\""+userId+"+\"}";
        String result = restTemplate.postForObject(url, reqJson, String.class);
        try {
            JsonNode jsonNode = objectMapper.reader().readTree(result);
            JsonNode data = jsonNode.get("data");
            JsonNode email = data.get("email");
            return email.toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
