package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.BookDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "book")
public class BookDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "book_id")
    @ApiModelProperty("图书id")
    private String bookId;

    @Column(name = "book_name")
    @ApiModelProperty("书名")
    private String bookName;

    @Column(name = "book_author")
    @ApiModelProperty("作者")
    private String bookAuthor;

    @Column(name = "book_isbn")
    @ApiModelProperty("图书国际编号")
    private String bookIsbn;

    @Column(name = "book_category")
    @ApiModelProperty("图书类别")
    private Integer bookCategory;

    @Column(name = "book_publish")
    @ApiModelProperty("出版社")
    private String bookPublish;

    @Column(name = "book_publish_time")
    @ApiModelProperty("出版时间")
    private String bookPublishTime;

    @Column(name = "book_oldprice")
    @ApiModelProperty("图书原价")
    private BigDecimal bookOldPrice;

    @Column(name = "book_newprice")
    @ApiModelProperty("图书价格")
    private BigDecimal bookNewPrice;

    @Column(name = "book_detail")
    @ApiModelProperty("图书详情介绍")
    private String bookDetail;

    @Column(name = "admin_id")
    @ApiModelProperty("商家id")
    private String adminId;

    @Column(name = "stock_count")
    @ApiModelProperty("库存数量")
    private Integer stockCount;

    @Column(name = "put_state")
    @ApiModelProperty("上架状态")
    private Boolean putState;

    /*
      以下固定五项字段
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifytime;
    //创建人id
    private Integer operatorid;
    //修改人id
    private Integer modifierid;
    //是否删除
    private Boolean isdelete;

    public BookDO(BookDTO bookDTO, Integer footId) {
        this.adminId = bookDTO.getAdminId();
        this.bookId = "b" + footId;
        this.bookName = bookDTO.getBookName();
        this.bookAuthor = bookDTO.getBookAuthor();
        this.bookIsbn = bookDTO.getBookIsbn();
        this.bookCategory = bookDTO.getBookCategory();
        this.bookPublish = bookDTO.getBookPublish();
        this.bookPublishTime = bookDTO.getBookPublishTime();
        this.bookOldPrice = new BigDecimal(bookDTO.getBookOldPrice());
        this.bookNewPrice = new BigDecimal(bookDTO.getBookNewPrice());
        this.bookDetail = bookDTO.getBookDetail();
        this.stockCount = bookDTO.getStockCount();
        this.isdelete = false;
        this.putState = true;
        this.modifytime = new Date();
    }
}
