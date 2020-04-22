package com.tsc.graduateproj.bokubookstore.command.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CartWithCountVO {

    @ApiModelProperty("数量")
    private Integer count;

    @ApiModelProperty("集合")
    private List<CartVO> cartVOS;

    public CartWithCountVO(Integer count,List<CartVO> cartVOS){
        this.count=count;
        this.cartVOS=cartVOS;
    }

}
