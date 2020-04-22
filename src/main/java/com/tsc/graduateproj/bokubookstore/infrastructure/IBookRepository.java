package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IBookRepository extends JpaRepository<BookDO,Integer>, JpaSpecificationExecutor<BookDO> {

    //查询所有图书
    @Query("select b from BookDO b where b.isdelete=false ")
    List<BookDO> findAllBooks();

    //根据图书类别查询图书
    @Query("select b from BookDO b where b.bookCategory=?1 and b.isdelete=false ")
    List<BookDO> findByBookCategory(Integer category);

    //首页轮播图每种获取两个
    @Query("select b from BookDO b where b.bookCategory=?1 and b.isdelete=false ")
    List<BookDO> findByBookCategory(Integer category,PageRequest page);

    //根据图书编号查询图书
    @Query("select b from BookDO b where b.bookId=?1 and b.isdelete=false ")
    BookDO findByBookId(String bookId);

    //根据商家id查询图书
    @Query("select b from BookDO b where b.adminId=?1 and b.isdelete=false ")
    List<BookDO> findByAdminId(String adminId);

    //查询最后一本书
    @Query("select b from BookDO b where b.isdelete=false order by b.bookId desc ")
    BookDO findLastBook(PageRequest page);

    //查询图书数
    @Query("select count(b) from BookDO b where b.isdelete=false ")
    Integer queryNum();

    //删除图书
    @Modifying
    @Query("update BookDO b set b.isdelete=true where b.bookId=?1")
    void deleteByBookId(String bookId);

    //根据书名查询
    @Query("select b from BookDO b where b.bookName like %?1% and b.isdelete=false ")
    List<BookDO> findBookByName(String bookName);


}
