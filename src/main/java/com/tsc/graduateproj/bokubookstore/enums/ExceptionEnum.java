package com.tsc.graduateproj.bokubookstore.enums;

import lombok.Getter;

@Getter
public enum  ExceptionEnum {

    USER_NAME_EXIST(970731,"该用户名已注册，请更改用户名！"),
    USER_NOT_REGIST(970732,"您尚未注册，请先注册后再登陆！"),
    USERNAME_OR_PASSWORD_ERROR(970733,"用户名或密码错误，请重新输入！"),

    ADMIN_NAME_EXIST(970734,"该商家名已注册，请更改商家名！"),
    ADMIN_NOT_REGIST(970735,"您尚未注册，请先注册后再登陆！"),
    ADMINNAME_OR_PASSWORD_ERROR(970736,"商家名或密码错误，请重新输入！"),

    NOTLOGIN(970737,"请先登录再进行操作！");

    private Integer code;

    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
