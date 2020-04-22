package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BookVO {

    @ApiModelProperty("图书id")
    private String bookId;

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

    @ApiModelProperty("主图片")
    private String bookPicture;

    @ApiModelProperty("图书原价")
    private String bookOldPrice;

    @ApiModelProperty("图书价格")
    private String bookNewPrice;

    @ApiModelProperty("图书详情介绍")
    private String bookDetail;

    public BookVO(BookDO bookDO,String mainPic){
        this.bookId=bookDO.getBookId();
        this.bookName=bookDO.getBookName();
        this.bookAuthor=bookDO.getBookAuthor();
        this.bookIsbn=bookDO.getBookIsbn();
        this.bookCategory=bookDO.getBookCategory();
        this.bookPublish=bookDO.getBookPublish();
        this.bookPublishTime=bookDO.getBookPublishTime();
        this.bookPicture=mainPic;
        this.bookOldPrice=bookDO.getBookOldPrice().toPlainString();
        this.bookNewPrice=bookDO.getBookNewPrice().toPlainString();
        this.bookDetail=bookDO.getBookDetail();
    }

}
