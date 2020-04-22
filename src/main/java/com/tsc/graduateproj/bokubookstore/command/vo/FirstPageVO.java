package com.tsc.graduateproj.bokubookstore.command.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FirstPageVO {

    @ApiModelProperty("轮播图")
    List<PictureAndBookIdVO> RotationPictureList;

    @ApiModelProperty("精选图书")
    BookWithCountVO selectedBooks;

    @ApiModelProperty("推荐图书")
    BookWithCountVO recommendedBooks;

    @ApiModelProperty("热卖图书")
    BookWithCountVO hotsellBooks;


}
