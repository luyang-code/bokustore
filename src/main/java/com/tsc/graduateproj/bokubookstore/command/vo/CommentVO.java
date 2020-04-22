package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.CommentDO;
import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import com.tsc.graduateproj.bokubookstore.util.DateUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CommentVO {

    @ApiModelProperty("图书id")
    private String bookId;

    @ApiModelProperty("评论人")
    private String commentPerson;

    @ApiModelProperty("评论内容")
    private String commentContent;

    @ApiModelProperty("评论等级")
    private Integer commentStar;

    @ApiModelProperty("评论时间")
    private String commentTime;

    public CommentVO(CommentDO commentDO, UserDO userDO,String bookId){
        this.bookId=bookId;
        this.commentPerson=userDO.getUserName();
        this.commentContent=commentDO.getComment();
        this.commentStar=commentDO.getCommentStar();
        this.commentTime=new SimpleDateFormat(DateUtils.DATETOSECOND).format(commentDO.getCommentTime());
    }

}
