package com.tsc.graduateproj.bokubookstore.util;

import com.tsc.graduateproj.bokubookstore.enums.ExceptionEnum;

public class ExceptionUtil {

    public static void isEmpty(Object o){
        if (null == o){
            throw new BusinessException(100000,"参数错误");
        }
    }

    public static void isEmpty(Object o, ExceptionEnum e){
        if (null == o){
            throw new BusinessException(e.getCode(),e.getMessage());
        }
    }

    public static void throwException(boolean o, ExceptionEnum e){
        if (o){
            throw new BusinessException(e.getCode(), e.getMessage());
        }
    }

}
