package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.command.dto.PictureDTO;
import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import com.tsc.graduateproj.bokubookstore.domain.model.PictureDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDetailVO {

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

    @ApiModelProperty("图片路径")
    private List<PictureDTO> bookPictures;

    @ApiModelProperty("图书原价")
    private BigDecimal bookOldPrice;

    @ApiModelProperty("图书价格")
    private BigDecimal bookNewPrice;

    @ApiModelProperty("图书详情介绍")
    private String bookDetail;

    @ApiModelProperty("上架状态")
    private Boolean putState;

    @ApiModelProperty("库存数量")
    private Integer stockCount;

    public BookDetailVO(BookDO bookDO, List<PictureDTO> pictures){
        this.bookId=bookDO.getBookId();
        this.bookName=bookDO.getBookName();
        this.bookAuthor=bookDO.getBookAuthor();
        this.bookIsbn=bookDO.getBookIsbn();
        this.bookCategory=bookDO.getBookCategory();
        this.bookPublish=bookDO.getBookPublish();
        this.bookPublishTime=bookDO.getBookPublishTime();
        this.bookPictures=pictures;
        this.bookOldPrice=bookDO.getBookOldPrice();
        this.bookNewPrice=bookDO.getBookNewPrice();
        this.bookDetail=bookDO.getBookDetail();
        this.putState=bookDO.getPutState();
        this.stockCount=bookDO.getStockCount();
    }

}
