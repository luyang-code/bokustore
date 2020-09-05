package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.AdminDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminVO {

    @ApiModelProperty("商家id")
    private String adminId;

    @ApiModelProperty("商家名")
    private String adminName;

    @ApiModelProperty("商家密码")
    private String adminPassword;

    @ApiModelProperty("电话")
    private String adminPhone;

    @ApiModelProperty("性别")
    private String adminSex;

    @ApiModelProperty("是否是管理员")
    private Boolean isSuperAdmin;

    public AdminVO(AdminDO adminDO){
        this.adminId=adminDO.getAdminId();
        this.adminName=adminDO.getAdminName();
        this.adminPassword=adminDO.getAdminPassword();
        this.adminPhone=adminDO.getAdminPhone();
        this.adminSex=adminDO.getAdminSex();
        this.isSuperAdmin=adminDO.getIsSuperAdmin();

    }

}
