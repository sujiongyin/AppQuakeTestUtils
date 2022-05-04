package com.ooooo.quake.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域拦截器
 */
public class ControllerInterceptor implements HandlerInterceptor {

    /**
     * 每次预处理请求逻辑
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, CorsConfiguration.ALL);
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, CorsConfiguration.ALL);
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, CorsConfiguration.ALL);
        response.addHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, CorsConfiguration.ALL);
        response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
            // 响应缓存
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return true;
    }
}
