package com.ooooo.quake.service.impl;

import com.ooooo.quake.dao.OpenAuthenticationDao;
import com.ooooo.quake.responce.OpenAppAllResponce;
import com.ooooo.quake.service.OpenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OpenServiceImpl implements OpenService {

    @Autowired
    private OpenAuthenticationDao openAuthenticationDao;

    @Override
    public List<OpenAppAllResponce> OpenAuthenticationAll(OpenAppAllResponce openAppAllResult) {
        String app_id = openAppAllResult.getAppId();
        List<OpenAppAllResponce> openAppAllResults = openAuthenticationDao.OpenAuthenticationAll(app_id,20,0);
        return openAppAllResults;
    }
}
