package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.AddressDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "address")
public class AddressDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "custom_id")
    @ApiModelProperty("顾客id")
    private String customId;

    @Column(name = "address_id")
    @ApiModelProperty("地址id")
    private String addressId;

    @Column(name = "address")
    @ApiModelProperty("地址")
    private String address;

    @Column(name = "receiver")
    @ApiModelProperty("收货人姓名")
    private String receiver;

    @Column(name = "custom_phone")
    @ApiModelProperty("顾客电话")
    private String customPhone;

    @Column(name = "isdefault")
    @ApiModelProperty("是否为默认地址")
    private Boolean isdefault;

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

    public AddressDO(AddressDTO addressDTO,Integer footId){
        this.customId=addressDTO.getCustomId();
        this.addressId="add"+footId;
        this.address=addressDTO.getAddress();
        this.receiver=addressDTO.getReceiver();
        this.customPhone=addressDTO.getCustomPhone();
        this.isdefault=addressDTO.getIsdefault();
        this.isdelete=false;
    }

}

