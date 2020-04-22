package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.PictureDTO;
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
@Table(name = "picture")
public class PictureDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "book_id")
    @ApiModelProperty("图书id")
    private String bookId;

    @Column(name = "book_picture")
    @ApiModelProperty("图书路径")
    private String bookPicture;

    @Column(name = "main_pic")
    @ApiModelProperty("是否为主图")
    private Boolean mainPic;


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

    public PictureDO(String bookId,PictureDTO img){
        this.bookId=bookId;
        this.bookPicture=img.getPictureUrl();
        this.mainPic=img.getMainPic();
        this.isdelete=false;
    }

}
