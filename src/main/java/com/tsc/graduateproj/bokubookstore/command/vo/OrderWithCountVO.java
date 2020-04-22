package com.tsc.graduateproj.bokubookstore.command.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderWithCountVO {

    @ApiModelProperty("数量")
    private Integer count;

    @ApiModelProperty("订单列表")
    private List<OrderVO> orderVOList;

    public OrderWithCountVO(Integer count,List<OrderVO> orderVOS){
         this.count=count;
         this.orderVOList=orderVOS;
    }
}
