package com.ooooo.quake.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ooooo.quake.aspect.annotation.Log;
import com.ooooo.quake.aspect.annotation.Page;
import com.ooooo.quake.dao.UserDao;
import com.ooooo.quake.dto.JsonData;
import com.ooooo.quake.dto.PageParam;
import com.ooooo.quake.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class DemoController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/demo")
    @Log
    public Object demo(@RequestBody Map<String, String> params, @Page PageParam pageParam) {
        log.info("params:{},  pageParam:{}", params, pageParam);
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<User> users = userDao.selectList(new LambdaQueryWrapper<>());
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return JsonData.buildSuccess(pageParam.getReuslt(userPageInfo));
    }

    /**
     * curl --location --request POST 'http://quake-test-api.o5brazil.com/demo' \
     * --header 'page: 5' \
     * --header 'size: 5' \
     * --header 'Content-Type: application/json' \
     * --data-raw '{
     *     "params":"123"
     * }'
     */
}
