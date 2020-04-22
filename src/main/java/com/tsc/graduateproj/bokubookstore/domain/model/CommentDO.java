package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsc.graduateproj.bokubookstore.command.dto.CommentDTO;
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
@Table(name = "comment")
public class CommentDO {

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

    @Column(name = "comment")
    @ApiModelProperty("评论内容")
    private String comment;

    @Column(name = "comment_star")
    @ApiModelProperty("评论等级")
    private Integer commentStar;

    @Column(name = "comment_time")
    @ApiModelProperty("评论时间")
    private Date commentTime;

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

    public CommentDO(CommentDTO commentDTO){
        this.bookId=commentDTO.getBookId();
        this.customId=commentDTO.getCustomId();
        this.comment=commentDTO.getComment();
        this.commentStar=commentDTO.getCommentStar();
        this.commentTime=new Date();
        this.isdelete=false;
    }

}
