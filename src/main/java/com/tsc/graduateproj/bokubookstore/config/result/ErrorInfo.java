package com.tsc.graduateproj.bokubookstore.config.result;

import lombok.Data;

@Data
public class ErrorInfo<T> {

    private String message;

    private Integer code;

    private T result;
}
