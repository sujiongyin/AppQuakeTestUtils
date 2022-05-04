package com.ooooo.quake.exception;

import com.ooooo.quake.dto.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloabelExceptionBussinesHandler {
    @ExceptionHandler(Exception.class)
    public JsonData error(Exception e){
       if (e instanceof BussinessException){
           BussinessException exception = (BussinessException) e;
           return JsonData.buildError(exception.getErrorCode());
       }else {
           return JsonData.buildError(ErrorCode.UNKONW_ERROR,e.getMessage());
       }
    }
}
