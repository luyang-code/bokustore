package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.UserRegistDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "user_id")
    @ApiModelProperty("用户id")
    private String userId;

    @Column(name = "user_name")
    @ApiModelProperty("用户姓名")
    private String userName;

    @Column(name = "user_password")
    @ApiModelProperty("用户密码")
    private String userPassword;

    @Column(name = "user_phone")
    @ApiModelProperty("手机号")
    private String userPhone;

    @Column(name = "user_sex")
    @ApiModelProperty("性别")
    private String userSex;

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

    public UserDO(UserRegistDTO userRegistDTO, Integer footId){
        this.userId="u"+footId;
        this.userName=userRegistDTO.getUserName();
        this.userPassword=userRegistDTO.getUserPassword();
        this.userPhone=userRegistDTO.getUserPhone();
        this.userSex=userRegistDTO.getUserSex().equals(man)?"男":"女";
        this.isdelete=false;
    }

}


