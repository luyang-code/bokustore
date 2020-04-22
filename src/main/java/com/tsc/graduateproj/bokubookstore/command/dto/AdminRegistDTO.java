package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRegistDTO {

    @ApiModelProperty("商家姓名")
    private String adminName;

    @ApiModelProperty("商家密码")
    private String adminPassword;

    @ApiModelProperty("电话")
    private String adminPhone;

    @ApiModelProperty("性别")
    private String adminSex;

}
