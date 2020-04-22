package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CartDTO {

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("顾客id")
    private String customId;

    @ApiModelProperty("购买数量")
    private Integer bookCount;

}
