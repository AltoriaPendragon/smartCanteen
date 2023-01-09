package com.firstproject.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.firstproject.controller.utils.Code.EXCEPTION_ERR;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public Result doException(Exception ex){
        ex.printStackTrace();
        return new Result(EXCEPTION_ERR, null , "服务器错误");
    }

}
