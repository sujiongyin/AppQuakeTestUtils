package com.ooooo.quake.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(* com.*.*.controller.*Controller.*(..)) && @annotation(com.ooooo.quake.aspect.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result;
        long beginTime = System.currentTimeMillis();
        // 执行方法
        result = point.proceed();
        //执行时长
        long time = System.currentTimeMillis() - beginTime;
        try {
            HttpServletRequest request = getRequest();

            MethodSignature signature = (MethodSignature) point.getSignature();
            String methodName = signature.getMethod().getName();

            // 请求参数
            Map<String, Object> parameter = getParameter(signature.getParameterNames(), point);
            String jsonParam = JSONObject.toJSONString(parameter);

            if (jsonParam.getBytes(StandardCharsets.UTF_8).length > 512) {
                jsonParam = new String(jsonParam.getBytes(StandardCharsets.UTF_8), 0, 509) + "...";
            }

            // 请求ip
            String realIp = getRealIp(request);

            log.info("realIp:{} method:{} request:{} response:{}", realIp, methodName, jsonParam, JSONObject.toJSONString(result));


        } catch (Exception e) {
            log.error("日志模块出错", e);
        }
        return result;
    }

    /**
     * 获取请求实体
     *
     * @return
     */
    private static HttpServletRequest getRequest() {
        Object requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request;
        }
        return null;
    }

    //返回方法的参数名
    private String getParameters(ProceedingJoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {
        StringBuilder sb = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        for (int k = 0; k < args.length; k++) {
            if (!args[k].getClass().isPrimitive()) {
                if (!args[k].getClass().isInstance(HttpServletRequest.class) && !args[k].getClass().isInstance(HttpServletResponse.class)) {
                    sb.append(JSON.toJSONString(args[k]));
                    break;
                }
            }
        }
        return sb.toString();
    }

    //获取访问者ip
    public static String getRealIp(HttpServletRequest request) {
        // 这个一般是Nginx反向代理设置的参数
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 处理多IP的情况（只取第一个IP）
        if (ip != null && ip.contains(",")) {
            String[] ipArray = ip.split(",");
            ip = ipArray[0];
        }
        return ip;
    }

    /**
     * 获取参数
     * @param parameterNames
     * @param point
     * @return
     */
    private Map<String, Object> getParameter(String[] parameterNames, ProceedingJoinPoint point) {
        // 请求的参数
        Object[] args = point.getArgs();
        Map<String, Object> parameter = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof HttpServletRequest) {
                Map<String, String[]> map = ((HttpServletRequest) args[i]).getParameterMap();
                args[i] = map;
            } else if (args[i] instanceof HttpServletResponse) {
                args[i] = null;
            } else if (args[i] instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) args[i];
                args[i] = "文件名：" + file.getOriginalFilename() + "，：文件大小" + file.getSize();
            }
            if (args[i] != null) {
                parameter.put(parameterNames[i], args[i]);
            }
        }
        return parameter;
    }
}