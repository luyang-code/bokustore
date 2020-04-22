package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.CartDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "cart")
public class CartDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "book_id")
    @ApiModelProperty("图书id")
    private String bookId;

    @Column(name = "custom_id")
    @ApiModelProperty("顾客id")
    private String customId;

    @Column(name = "book_count")
    @ApiModelProperty("购买数量")
    private Integer bookCount;

    @Column(name = "add_time")
    @ApiModelProperty("加购时间")
    private Date addTime;

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

    public CartDO(CartDTO cartDTO){
        this.bookId=cartDTO.getBookId();
        this.customId=cartDTO.getCustomId();
        this.bookCount=cartDTO.getBookCount();
        this.addTime=new Date();
        this.isdelete=false;
    }

}
