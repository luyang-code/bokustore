package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.CommentDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.CommentsWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bokustore/comment")
@Api(value = "CommentController", tags = {"评论"})
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @ApiOperation("根据bookId查询评论信息")
    @GetMapping("/comments/{page}/{size}/{bookId}")
    public CommentsWithCountVO findCommentsByBookId(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("bookId") String bookId){
        return commentService.findCommentsByBookId(page,size,bookId);
    }

    @ApiOperation("添加评论")
    @PostMapping("/addComments")
    public Boolean addComment(@RequestBody CommentDTO commentDTO){
        return commentService.addComment(commentDTO);
    }


}
