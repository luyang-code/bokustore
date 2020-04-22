package com.tsc.graduateproj.bokubookstore.config;

import com.alibaba.fastjson.JSON;
import com.tsc.graduateproj.bokubookstore.config.result.ErrorInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * springboot controller统一restful返回值的处理
 */

@EnableWebMvc
@Configuration
public class GlobalReturnConfig {

    @RestControllerAdvice
    public static class ResultResponseAdvice implements ResponseBodyAdvice<Object> {
        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            // 对body进行封装处理
            if (body instanceof ErrorInfo) {
                return body;
            }
            if (serverHttpRequest.getURI().getPath().equals("/")||serverHttpRequest.getURI().getPath().equals("/index.html"))
                return body;
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setCode(1000);
            errorInfo.setMessage("ok");
            errorInfo.setResult(body);
            if(body instanceof String) return JSON.toJSONString(errorInfo);
            return errorInfo;
        }
    }
}