package com.tsc.graduateproj.bokubookstore.command.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookWithCountVO {

    @ApiModelProperty("数量")
    private Integer count;

    @ApiModelProperty("集合")
    private List<BookVO> bookVOList;

    public BookWithCountVO(Integer count,List<BookVO> bookVOList){
        this.count=count;
        this.bookVOList=bookVOList;
    }

}
