package com.tsc.graduateproj.bokubookstore.command.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDTO {

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("顾客id")
    private String customId;

    @ApiModelProperty("评论内容")
    private String comment;

    @ApiModelProperty("评论等级")
    private Integer commentStar;

}
