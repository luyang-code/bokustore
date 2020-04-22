package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BookDTO {

    @ApiModelProperty("书名")
    private String bookName;

    @ApiModelProperty("作者")
    private String bookAuthor;

    @ApiModelProperty("图书国际编号")
    private String bookIsbn;

    @ApiModelProperty("图书类别")
    private Integer bookCategory;

    @ApiModelProperty("出版社")
    private String bookPublish;

    @ApiModelProperty("出版时间")
    private String bookPublishTime;

    @ApiModelProperty("图书原价")
    private String bookOldPrice;

    @ApiModelProperty("图书价格")
    private String bookNewPrice;

    @ApiModelProperty("图书详情介绍")
    private String bookDetail;

    @ApiModelProperty("商家id")
    private String adminId;

    @ApiModelProperty("图片集合")
    private List<PictureDTO> bookPictures;

}
