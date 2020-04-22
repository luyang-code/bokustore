package com.tsc.graduateproj.bokubookstore.command.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommentsWithCountVO {

    @ApiModelProperty("数量")
    private Integer count;

    @ApiModelProperty("集合")
    private List<CommentVO> commentVOS;

    public CommentsWithCountVO(Integer count,List<CommentVO> commentVOS){
        this.count=count;
        this.commentVOS=commentVOS;
    }
}
