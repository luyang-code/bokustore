package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderDTO {

    @ApiModelProperty("顾客id")
    private String customId;

    @ApiModelProperty("地址id")
    private String addressId;

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("图书数量")
    private Integer bookCount;

    @ApiModelProperty("订单价")
    private String orderPrice;

}
