package com.tsc.graduateproj.bokubookstore.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "rotation_pic")
public class RotationPicDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键id")
    private Integer id;

    @Column(name = "rotation_pic")
    @ApiModelProperty("轮播图")
    private String rotationPic;

    @Column(name = "book_id")
    @ApiModelProperty("图书id")
    private String bookId="";

    @Column(name = "isdelete")
    @ApiModelProperty("是否删除")
    private Boolean isdelete;

    public RotationPicDO(String rotationPic){
        this.rotationPic=rotationPic;
        this.isdelete=false;
    }

}
