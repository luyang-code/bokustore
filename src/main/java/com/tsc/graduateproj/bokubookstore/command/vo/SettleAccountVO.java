package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import com.tsc.graduateproj.bokubookstore.domain.model.CartDO;
import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SettleAccountVO {

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("主图片路径")
    private String mainBookPicture;

//    @ApiModelProperty("用户姓名")
//    private String userName;

    @ApiModelProperty("用户手机")
    private String phone;

    @ApiModelProperty("收货地址")
    private AddressVO address;

    @ApiModelProperty("图书")
    private String bookName;

    @ApiModelProperty("图书详情")
    private String bookDetail;

    @ApiModelProperty("购买数量")
    private Integer bookCount;

    @ApiModelProperty("原价格")
    private BigDecimal bookOldPrice;

    @ApiModelProperty("新价格")
    private BigDecimal bookNewPrice;

    @ApiModelProperty("商家id")
    private String adminId;

    public SettleAccountVO(CartDO cartDO, String mainPic, BookDO bookDO, AddressVO addressVO){
        this.bookId=bookDO.getBookId();
        this.mainBookPicture=mainPic;
//        this.userName=addressVO.getReceiver();
        this.phone=addressVO.getPhone();
        this.address=addressVO;
        this.bookName=bookDO.getBookName();
        this.bookDetail=bookDO.getBookDetail();
        this.bookCount=cartDO.getBookCount();
        this.bookOldPrice=bookDO.getBookOldPrice();
        this.bookNewPrice=bookDO.getBookNewPrice();
        this.adminId=bookDO.getAdminId();
    }

    //直接购买
    public SettleAccountVO(Integer bookCount, String mainPic, BookDO bookDO, AddressVO addressVO){
        this.bookId=bookDO.getBookId();
        this.mainBookPicture=mainPic;
//        this.userName=addressVO.getReceiver();
        this.phone=addressVO.getPhone();
        this.address=addressVO;
        this.bookName=bookDO.getBookName();
        this.bookDetail=bookDO.getBookDetail();
        this.bookCount=bookCount;
        this.bookOldPrice=bookDO.getBookOldPrice();
        this.bookNewPrice=bookDO.getBookNewPrice();
        this.adminId=bookDO.getAdminId();
    }

}
