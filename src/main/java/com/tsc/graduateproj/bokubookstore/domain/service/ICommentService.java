package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.CommentDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.CommentVO;
import com.tsc.graduateproj.bokubookstore.command.vo.CommentsWithCountVO;

import java.util.List;

public interface ICommentService {

    //查询所有评论
    CommentsWithCountVO findCommentsByBookId(Integer page,Integer size,String bookId);

    //添加评论
    Boolean addComment(CommentDTO commentDTO);

}
