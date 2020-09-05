package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.BackBookParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.BookDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.BookParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.DirectBuyBookDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.*;
import com.tsc.graduateproj.bokubookstore.domain.service.IBookService;
import com.tsc.graduateproj.bokubookstore.util.MyFTP;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/bokustore/book")
@Api(value = "BookController", tags = {"图书"})
public class BookController {

    @Autowired
    private IBookService bookService;

    @ApiOperation("获取首页信息")
    @GetMapping("/firstPage/{page}/{size}")
    public FirstPageVO getFirstPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return bookService.getFirstPage(page, size);
    }

    @ApiOperation("根据图书id查询单条图书信息(图书详情)")
    @GetMapping("/singleDataBook/{bookId}")
    public BookDetailVO findByBookId(@PathVariable("bookId") String bookId) {
        return bookService.findByBookId(bookId);
    }

    @ApiOperation("根据书名模糊查询图书")
    @GetMapping("/findBookByName/{bookName}")
    public List<BookDetailVO> findBookByName(@PathVariable("bookName") String bookName) {
        return bookService.findBookByName(bookName);
    }

    @ApiOperation("根据图书类别查询图书信息")
    @GetMapping("/books/{page}/{size}/{category}")
    public BookWithCountVO findByCategory(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("category") Integer category) {
        return bookService.findByBookCategory(page, size, category);
    }

    @ApiOperation("根据商家id查询图书信息")
    @GetMapping("/book1s/{page}/{size}/{adminId}")
    public BookWithCountVO findByAdminId(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable("adminId") String adminId) {
        return bookService.findByAdminId(page, size, adminId);
    }

    @ApiOperation("上传图书信息")
    @PostMapping("/addBook")
    public Boolean addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @ApiOperation("上传图片到服务器")
    @PostMapping("/upload")
    public String uploadImg(@RequestParam("picture") MultipartFile picture) throws IOException {
        return MyFTP.ftpUpLoadImg(picture);
    }

    @ApiOperation("删除图书信息")
    @PostMapping("/deleteBook/{bookId}")
    public Boolean deleteBook(@PathVariable("bookId") String bookId) {
        return bookService.deleteBook(bookId);
    }

    @ApiOperation("修改图书信息")
    @PostMapping("/modifyBook/{bookId}")
    public Boolean modifyBook(@PathVariable("bookId") String bookId, @RequestBody BookDTO bookDTO) {
        return bookService.modifyBook(bookId, bookDTO);
    }

    @ApiOperation("商品详情页面直接购买")
    @PostMapping("/directBuyBook")
    public SettleAccountVO directBuyBook(@RequestBody DirectBuyBookDTO directBuyBookDTO) {
        return bookService.directBuyBook(directBuyBookDTO);
    }

    @ApiOperation("上传轮播图")
    @PostMapping("/uploadRotationPic")
    public Boolean uploadRotationPic(@RequestParam("picture") MultipartFile picture) throws IOException {
        String rotationPic = MyFTP.ftpUpLoadImg(picture);
        return bookService.addRotationPic(rotationPic);
    }

    @ApiOperation("搜索销量前十图书")
    @GetMapping("/getTopTenBooks")
    public List<BookVO> getTopTenBooks() {
        return bookService.getTopTenBooks();
    }

    @ApiOperation("首页根据书名或者作者搜索图书，还支持根据出版时间，价格区间搜索")
    @PostMapping("/searchBooks/{page}/{size}")
    public BookWithCountVO searchBooks(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @RequestBody BookParamDTO dto) {
        return bookService.searchBooks(page, size, dto);
    }

    @ApiOperation("商家后台根据书名或者作者搜索图书，还支持根据出版时间，价格区间搜索")
    @PostMapping("/backSearchBooks/{page}/{size}/{adminId}")
    public BookWithCountVO backSearchBooks(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @RequestBody @Valid BackBookParamDTO dto) {
        return bookService.backSearchBooks(page, size, dto);
    }

    @ApiOperation("修改上架状态")
    @GetMapping("/modifyGoodsState/{bookId}/{state}")
    public void modifyGoodsState(@PathVariable("bookId") String bookId,@PathVariable("state") Boolean state) {
            bookService.modifyGoodsState(bookId,state);
    }

}
