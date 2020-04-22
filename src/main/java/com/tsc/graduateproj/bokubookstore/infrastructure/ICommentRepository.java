package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.CommentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentRepository extends JpaRepository<CommentDO,Integer>, JpaSpecificationExecutor<CommentDO> {

    @Query("select c from CommentDO c where c.bookId=?1 and c.isdelete=false order by c.commentTime desc ")
    List<CommentDO> findCommentsByBookId(String bookId);

}
