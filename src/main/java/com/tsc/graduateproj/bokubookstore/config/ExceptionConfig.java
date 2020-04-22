package com.tsc.graduateproj.bokubookstore.config;

import com.tsc.graduateproj.bokubookstore.config.result.ErrorInfo;
import com.tsc.graduateproj.bokubookstore.util.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringBoot配置全局异常捕获
 */
@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ErrorInfo<String> jsonHandler(HttpServletRequest request, BusinessException e){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setResult("发生异常");
        r.setMessage(e.getMessage());
        r.setCode(e.getCode());
        return r;
    }
}
