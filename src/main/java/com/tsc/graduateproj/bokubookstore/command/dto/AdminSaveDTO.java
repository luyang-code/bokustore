package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminSaveDTO {

    @ApiModelProperty("商家id")
    private String adminId;

    @ApiModelProperty("商家名")
    private String adminName;

    @ApiModelProperty("商家密码")
    private String adminPassword;

    @ApiModelProperty("性别")
    private String adminSex;

}
