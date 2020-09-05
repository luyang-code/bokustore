package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.BackBookParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.BookDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.BookParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.DirectBuyBookDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.*;

import java.util.List;

public interface IBookService {

    //查询所有图书
    List<BookVO> findAllBooks();

    //获取首页信息
    FirstPageVO getFirstPage(Integer page,Integer size);

    //根据图书类别查询图书
    BookWithCountVO findByBookCategory(Integer page,Integer size,Integer category);

    //根据图书号查询图书详情
    BookDetailVO findByBookId(String bookId);

    //根据商家id搜索对应的图书
    BookWithCountVO findByAdminId(Integer page,Integer size,String adminId);

    //添加图书信息
    Boolean addBook(BookDTO bookDTO);

    //删除图书
    Boolean deleteBook(String bookId);

    //修改图书信息
    Boolean modifyBook(String bookId,BookDTO bookDTO);

    //根据书名模糊查询图书
    List<BookDetailVO> findBookByName(String bookName);

    //商品详情直接购买
    SettleAccountVO directBuyBook(DirectBuyBookDTO directBuyBookDTO);

    //上传轮播图
    Boolean addRotationPic(String rotationPic);

    //获取销量前十
    List<BookVO> getTopTenBooks();

    //首页搜索图书
    BookWithCountVO searchBooks(Integer page, Integer size, BookParamDTO dto);

    //商家后台搜索图书
    BookWithCountVO backSearchBooks(Integer page, Integer size, BackBookParamDTO dto);

    void modifyGoodsState(String bookId,Boolean state);

}
