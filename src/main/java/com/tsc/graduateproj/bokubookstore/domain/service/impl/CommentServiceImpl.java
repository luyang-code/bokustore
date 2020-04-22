package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.CommentDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.CommentVO;
import com.tsc.graduateproj.bokubookstore.command.vo.CommentsWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.model.CommentDO;
import com.tsc.graduateproj.bokubookstore.domain.service.ICommentService;
import com.tsc.graduateproj.bokubookstore.infrastructure.ICommentRepository;
import com.tsc.graduateproj.bokubookstore.infrastructure.IUserRepository;
import com.tsc.graduateproj.bokubookstore.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public CommentsWithCountVO findCommentsByBookId(Integer page,Integer size,String bookId) {
        List<CommentVO> commentVOS = commentRepository.findCommentsByBookId(bookId).stream().map(comment ->
                new CommentVO(comment, userRepository.findByUserId(comment.getCustomId()), bookId)).collect(Collectors.toList());
        return new CommentsWithCountVO(commentVOS.size(), ListUtils.page(commentVOS, page, size));
    }

    @Override
    public Boolean addComment(CommentDTO commentDTO) {
        commentRepository.save(new CommentDO(commentDTO));
        return true;
    }
}
