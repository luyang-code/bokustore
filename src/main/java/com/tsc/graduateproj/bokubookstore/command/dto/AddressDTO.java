package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    @ApiModelProperty("顾客id")
    private String customId;

    @ApiModelProperty("收货人网名")
    private String receiver;

    @ApiModelProperty("顾客电话")
    private String customPhone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("是否为默认地址")
    private Boolean isdefault=false;

}
