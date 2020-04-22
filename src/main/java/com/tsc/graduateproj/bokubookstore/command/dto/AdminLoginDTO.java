package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginDTO {

    @ApiModelProperty("商家名")
    private String adminName;

    @ApiModelProperty("商家密码")
    private String adminPassword;

}
