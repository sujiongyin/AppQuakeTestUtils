package com.ooooo.quake.dao;

import com.ooooo.quake.responce.OpenAppAllResponce;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OpenAuthenticationDao {

    List<OpenAppAllResponce> OpenAuthenticationAll(@Param("app_id") String app_id, @Param("limit") Integer limit, @Param("offset") Integer offset);
}
