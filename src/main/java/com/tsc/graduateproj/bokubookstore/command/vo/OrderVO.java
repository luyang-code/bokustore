package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import com.tsc.graduateproj.bokubookstore.domain.model.OrderDO;
import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import com.tsc.graduateproj.bokubookstore.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;

@Getter
@Setter
public class OrderVO {

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("订单编号")
    private String orderNumber;

    @ApiModelProperty("收货人")
    private String customName;

    @ApiModelProperty("收货人地址")
    private String address;

    @ApiModelProperty("图书名")
    private String bookName;

    @ApiModelProperty("图书作者")
    private String bookAuthor;

    @ApiModelProperty("图书图片")
    private String bookPicture;

    @ApiModelProperty("图书数量")
    private Integer bookCount;

    @ApiModelProperty("订单总价")
    private String orderTotalPrice;

    @ApiModelProperty("订单状态")
    private Integer orderState;

    @ApiModelProperty("下单时间")
    private String orderTime;

    @ApiModelProperty("顾客电话")
    private String customPhone;

    public OrderVO(OrderDO orderDO, UserDO userDO, BookDO bookDO,String mainPic){
        this.bookId=bookDO.getBookId();
        this.orderNumber=orderDO.getOrderNumber();
        this.customName=userDO.getUserName();
        this.address= orderDO.getAddress();
        this.bookName=bookDO.getBookName();
        this.bookAuthor=bookDO.getBookAuthor();
        this.bookPicture=mainPic;
        this.bookCount=orderDO.getBookCount();
        this.orderTotalPrice=orderDO.getOrderPrice().toPlainString();
        this.orderState=orderDO.getOrderState();
        this.orderTime=new SimpleDateFormat(DateUtils.DATETOSECOND).format(orderDO.getOrderTime());
        this.customPhone=orderDO.getPhone();

    }

}
