package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.BookDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.DirectBuyBookDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.PictureDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.*;
import com.tsc.graduateproj.bokubookstore.domain.model.*;
import com.tsc.graduateproj.bokubookstore.domain.service.IBookService;
import com.tsc.graduateproj.bokubookstore.enums.ExceptionEnum;
import com.tsc.graduateproj.bokubookstore.infrastructure.*;
import com.tsc.graduateproj.bokubookstore.util.ExceptionUtil;
import com.tsc.graduateproj.bokubookstore.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IPictureRepository pictureRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IRotationPicRepository rotationPicRepository;


    @Override
    public List<BookVO> findAllBooks() {
        return bookRepository.findAllBooks().stream().map(book -> {
            List<String> pictures = pictureRepository.findPictureByBookId(book.getBookId()).stream().
                    filter(p->p.getMainPic()==true).map(PictureDO::getBookPicture).collect(Collectors.toList());
            if(!ListUtils.isEmpty(pictures)) return new BookVO(book,"");
            return new BookVO(book, pictures.get(0));
        }).collect(Collectors.toList());
    }

    @Override
    public FirstPageVO getFirstPage(Integer page,Integer size) {
        FirstPageVO firstPageVO=new FirstPageVO();
//        List<PictureAndBookIdVO> RotationPictureList=new ArrayList<>();
//        for(Integer i=1;i<4;i++){
//            List<String> bookIds = bookRepository.findByBookCategory(i, PageRequest.of(0, 2)).stream().map(BookDO::getBookId).collect(Collectors.toList());
//            bookIds.forEach(bookId->{
//                PictureAndBookIdVO pictureAndBookIdVO=new PictureAndBookIdVO();
//                List<PictureDO> picture = pictureRepository.findPictureByBookId(bookId).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
//                if(!ListUtils.isEmpty(picture)) {
//                    RotationPictureList.add(new PictureAndBookIdVO(picture.get(0).getBookPicture(),bookId));
//                }else{
//                    RotationPictureList.add(new PictureAndBookIdVO("",bookId));
//                }
//            });
//            if(i==1){
//                firstPageVO.setSelectedBooks(findByBookCategory(page, size, 1));
//            }else if(i==2){
//                firstPageVO.setRecommendedBooks(findByBookCategory(page, size, 2));
//            }else {
//                firstPageVO.setHotsellBooks(findByBookCategory(page, size, 3));
//            }
//        }
//        firstPageVO.setRotationPictureList(RotationPictureList);
        firstPageVO.setSelectedBooks(findByBookCategory(page, size, 1));
        firstPageVO.setRecommendedBooks(findByBookCategory(page, size, 2));
        firstPageVO.setHotsellBooks(findByBookCategory(page, size, 3));
        List<PictureAndBookIdVO> pictureAndBookIdVOS = rotationPicRepository.queryRotationPic().stream().map(rotationPic ->
                new PictureAndBookIdVO(rotationPic.getRotationPic(), rotationPic.getBookId())).collect(Collectors.toList());
        firstPageVO.setRotationPictureList(pictureAndBookIdVOS);
        return firstPageVO;
    }

    @Override
    public BookWithCountVO findByBookCategory(Integer page,Integer size,Integer category) {
        List<BookVO> bookVOList = bookRepository.findByBookCategory(category).stream().map(boook -> {
            List<String> pictures = pictureRepository.findPictureByBookId(boook.getBookId()).stream().
                    filter(p -> p.getMainPic() == true).map(PictureDO::getBookPicture).collect(Collectors.toList());
            if (ListUtils.isEmpty(pictures)) return new BookVO(boook, "");
            return new BookVO(boook, pictures.get(0));
        }).collect(Collectors.toList());
        return new BookWithCountVO(bookVOList.size(),ListUtils.page(bookVOList, page, size));
    }

    @Override
    public BookDetailVO findByBookId(String bookId) {
        List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(bookId);
        List<PictureDTO> pictures = pictureDOS.stream().map(p->new PictureDTO(p.getBookPicture(),p.getMainPic())).collect(Collectors.toList());
        return new BookDetailVO(bookRepository.findByBookId(bookId),pictures);
    }

    @Override
    public List<BookDetailVO> findBookByName(String bookName) {
        List<BookDetailVO> bookDetailVOList=new ArrayList<>();
        List<BookDO> books = bookRepository.findBookByName(bookName);
        books.stream().forEach(book->{
            List<PictureDTO> pictures = pictureRepository.findPictureByBookId(book.getBookId()).stream()
                    .map(p -> new PictureDTO(p.getBookPicture(), p.getMainPic())).collect(Collectors.toList());
            bookDetailVOList.add(new BookDetailVO(book,pictures));
        });
        return bookDetailVOList;
    }

    @Override
    public SettleAccountVO directBuyBook(DirectBuyBookDTO directBuyBookDTO) {
        BookDO bookDO = bookRepository.findByBookId(directBuyBookDTO.getBookId());
        UserDO user = userRepository.findByUserId(directBuyBookDTO.getUserId());
        ExceptionUtil.throwException(StringUtils.isEmpty(user), ExceptionEnum.NOTLOGIN);
        List<AddressVO> addressVOS=addressRepository.findAddressByUserId(user.getUserId()).stream()
                .filter(AddressDO::getIsdefault).map(address -> new AddressVO(address)).collect(Collectors.toList());
        AddressVO addressVO=new AddressVO();
        if(!ListUtils.isEmpty(addressVOS)) addressVO=addressVOS.get(0);
        List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(directBuyBookDTO.getBookId()).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
        String mainPic="";
        if(!ListUtils.isEmpty(pictureDOS)) mainPic=pictureDOS.get(0).getBookPicture();
        return new SettleAccountVO(directBuyBookDTO.getCount(),mainPic,bookDO,addressVO);

    }

    @Override
    public Boolean addRotationPic(String rotationPic) {
        rotationPicRepository.save(new RotationPicDO(rotationPic));
        return true;
    }

    @Override
    public BookWithCountVO findByAdminId(Integer page,Integer size,String adminId) {
        List<BookVO> bookVOS = bookRepository.findByAdminId(adminId).stream().map(book -> {
            List<String> pictures = pictureRepository.findPictureByBookId(book.getBookId()).stream().
                    filter(p -> p.getMainPic() == true).map(PictureDO::getBookPicture).collect(Collectors.toList());
            if (ListUtils.isEmpty(pictures)) return new BookVO(book, "");
            return new BookVO(book, pictures.get(0));
        }).collect(Collectors.toList());
        return new BookWithCountVO(bookVOS.size(),ListUtils.page(bookVOS, page, size));
    }

    @Override
    public Boolean addBook(BookDTO bookDTO) {
        Integer id;
        if(bookRepository.queryNum()==0) {
            id=101;
        }else {
            id = Integer.parseInt(bookRepository.findLastBook(PageRequest.of(0,1)).getBookId().substring(1))+1;
        }
        BookDO book = bookRepository.save(new BookDO(bookDTO, id));
        pictureRepository.saveAll(bookDTO.getBookPictures().stream().map(img -> new PictureDO(book.getBookId(), img)).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    @Override
    public Boolean deleteBook(String bookId) {
        bookRepository.deleteByBookId(bookId);
        pictureRepository.deletePicByBookId(bookId);
        return true;
    }

    @Transactional
    @Override
    public Boolean modifyBook(String bookId, BookDTO bookDTO) {
        BookDO bookDO = bookRepository.findByBookId(bookId);
        bookRepository.save(modifyBook(bookDO,bookDTO));
        pictureRepository.deletePicByBookId(bookId);
        if(!ListUtils.isEmpty(bookDTO.getBookPictures())){
            pictureRepository.saveAll(bookDTO.getBookPictures().stream()
                    .map(img -> new PictureDO(bookDO.getBookId(), img)).collect(Collectors.toList()));
        }
        return true;
    }

    //修改
    private BookDO modifyBook(BookDO bookDO,BookDTO bookDTO){
        bookDO.setBookName(bookDTO.getBookName());
        if(!StringUtils.isEmpty(bookDTO.getBookCategory()))bookDO.setBookCategory(bookDTO.getBookCategory());
        if(!StringUtils.isEmpty(bookDTO.getBookOldPrice()))bookDO.setBookOldPrice(new BigDecimal(bookDTO.getBookOldPrice()));
        if(!StringUtils.isEmpty(bookDTO.getBookNewPrice()))bookDO.setBookNewPrice(new BigDecimal(bookDTO.getBookNewPrice()));
        bookDO.setBookDetail(bookDTO.getBookDetail());
        return bookDO;
    }
}
