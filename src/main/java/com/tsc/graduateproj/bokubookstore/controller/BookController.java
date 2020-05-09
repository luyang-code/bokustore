package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.BookDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.DirectBuyBookDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.BookDetailVO;
import com.tsc.graduateproj.bokubookstore.command.vo.BookWithCountVO;
import com.tsc.graduateproj.bokubookstore.command.vo.FirstPageVO;
import com.tsc.graduateproj.bokubookstore.command.vo.SettleAccountVO;
import com.tsc.graduateproj.bokubookstore.domain.service.IBookService;
import com.tsc.graduateproj.bokubookstore.util.MyFTP;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public FirstPageVO getFirstPage(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        return bookService.getFirstPage(page,size);
    }

    @ApiOperation("根据图书id查询单条图书信息(图书详情)")
    @GetMapping("/singleDataBook/{bookId}")
    public BookDetailVO findByBookId(@PathVariable("bookId") String bookId){
        return bookService.findByBookId(bookId);
    }

    @ApiOperation("根据书名模糊查询图书")
    @GetMapping("/findBookByName/{bookName}")
    public List<BookDetailVO> findBookByName(@PathVariable("bookName") String bookName){
        return bookService.findBookByName(bookName);
    }

    @ApiOperation("根据图书类别查询图书信息")
    @GetMapping("/books/{page}/{size}/{category}")
    public BookWithCountVO findByCategory(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@PathVariable("category") Integer category){
        return bookService.findByBookCategory(page,size,category);
    }

    @ApiOperation("根据商家id查询图书信息")
    @GetMapping("/book1s/{page}/{size}/{adminId}")
    public BookWithCountVO findByAdminId(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@PathVariable("adminId") String adminId){
        return bookService.findByAdminId(page,size,adminId);
    }

    @ApiOperation("上传图书信息")
    @PostMapping("/addBook")
    public Boolean addBook(@RequestBody BookDTO bookDTO){
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
    public Boolean modifyBook(@PathVariable("bookId") String bookId,@RequestBody BookDTO bookDTO) {
        return bookService.modifyBook(bookId,bookDTO);
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





//    /**
//     * 读取信息
//     */
//    private byte[] readDeal(ServletInputStream inputStream){
//        byte[] bytes = new byte[20480];
//        try {
//            int i = inputStream.read(bytes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            //关闭流
//            close(inputStream);
//        }
//        return bytes;
//    }
//
//    //关闭流
//    private void close(Closeable... closeables){
//        for (Closeable closeable : closeables) {
//            if (null != closeable) {
//                try {
//                    closeable.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

}
