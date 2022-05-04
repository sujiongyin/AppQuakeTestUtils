package com.ooooo.quake;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@EnableDiscoveryClient
@EnableDubboConfig
@DubboComponentScan(basePackages = "com.ooooo.quake")
@MapperScan("com.ooooo.quake.dao")
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppQuakeTestUtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppQuakeTestUtilsApplication.class, args);
    }

}