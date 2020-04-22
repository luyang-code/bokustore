package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.AdminRegistDTO;
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
@Table(name = "admin")
public class AdminDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "admin_id")
    @ApiModelProperty("商家id")
    private String adminId;

    @Column(name = "admin_name")
    @ApiModelProperty("商家名")
    private String adminName;

    @Column(name = "admin_password")
    @ApiModelProperty("商家密码")
    private String adminPassword;

    @Column(name = "admin_phone")
    @ApiModelProperty("电话")
    private String adminPhone;

    @Column(name = "admin_sex")
    @ApiModelProperty("性别")
    private String adminSex;

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

    private static final String man="0";//传入“0”代表性别男

    public AdminDO(AdminRegistDTO adminRegistDTO, Integer footId){
        this.adminId="a"+footId;
        this.adminName=adminRegistDTO.getAdminName();
        this.adminPassword=adminRegistDTO.getAdminPassword();
        this.adminPhone=adminRegistDTO.getAdminPhone();
        this.adminSex=adminRegistDTO.getAdminSex().equals(man)?"男":"女";
        this.isdelete=false;
    }

}
