package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettleAccountDTO {

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("图书数量")
    private Integer bookCount;

    @ApiModelProperty("订单价")
    private String orderPrice;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("收货人")
    private String receiver;

    @ApiModelProperty("商家id")
    private String adminId;

}
