package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import com.tsc.graduateproj.bokubookstore.domain.model.CartDO;
import com.tsc.graduateproj.bokubookstore.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
public class CartVO {

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("主图片路径")
    private String mainBookPicture;

    @ApiModelProperty("图书")
    private String bookName;

    @ApiModelProperty("图书详情")
    private String bookDetail;

    @ApiModelProperty("购买数量")
    private Integer bookCount;

    @ApiModelProperty("原价格")
    private String bookOldPrice;

    @ApiModelProperty("新价格")
    private String bookNewPrice;

    @ApiModelProperty("加购时间")
    private String addTime;

    public CartVO(CartDO cartDO, BookDO bookDO, String mainPicture){
        this.bookId=bookDO.getBookId();
        this.mainBookPicture=mainPicture;
        this.bookName=bookDO.getBookName();
        this.bookDetail=bookDO.getBookDetail();
        this.bookCount=cartDO.getBookCount();
        this.bookOldPrice=bookDO.getBookOldPrice().toPlainString();
        this.bookNewPrice=bookDO.getBookNewPrice().toPlainString();
        this.addTime= new SimpleDateFormat(DateUtils.DATETOSECOND).format(cartDO.getAddTime());
    }

}
