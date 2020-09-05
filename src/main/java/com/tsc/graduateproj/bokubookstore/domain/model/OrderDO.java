package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.SettleAccountDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "book_order")
public class OrderDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "order_number")
    @ApiModelProperty("订单编号")
    private String orderNumber;

    @Column(name = "custom_id")
    @ApiModelProperty("顾客id")
    private String customId;

    @Column(name = "address_id")
    @ApiModelProperty("地址id")
    private String addressId;

    @Column(name = "book_id")
    @ApiModelProperty("图书id")
    private String bookId;

    @Column(name = "book_count")
    @ApiModelProperty("图书数量")
    private Integer bookCount;

    @Column(name = "order_price")
    @ApiModelProperty("订单价")
    private BigDecimal orderPrice;

    @Column(name = "order_state")
    @ApiModelProperty("订单状态")
    private Integer orderState;

    @Column(name = "order_time")
    @ApiModelProperty("下单时间")
    private Date orderTime;

    @Column(name = "address")
    @ApiModelProperty("地址")
    private String address;

    @Column(name = "phone")
    @ApiModelProperty("电话")
    private String phone;

    @Column(name = "receiver")
    @ApiModelProperty("收货人")
    private String receiver;

    @Column(name = "admin_id")
    @ApiModelProperty("商家id")
    private String adminId;

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

    public OrderDO(String userId, String addressId, SettleAccountDTO settleAccountDTO) {
        this.orderNumber = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + (int) (Math.random() * 9000 + 1000);
        this.customId = userId;
        this.addressId = addressId;
        this.bookId = settleAccountDTO.getBookId();
        this.bookCount = settleAccountDTO.getBookCount();
        this.orderPrice = new BigDecimal(settleAccountDTO.getOrderPrice());
        this.orderState = 0;
        this.orderTime = new Date();
        this.address = settleAccountDTO.getAddress();
        this.phone = settleAccountDTO.getPhone();
        this.receiver = settleAccountDTO.getReceiver();
        this.isdelete = false;
        this.adminId = settleAccountDTO.getAdminId();
    }

}
