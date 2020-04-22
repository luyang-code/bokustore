package com.tsc.graduateproj.bokubookstore.util;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private Integer code;
    private String message;

    public BusinessException(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
