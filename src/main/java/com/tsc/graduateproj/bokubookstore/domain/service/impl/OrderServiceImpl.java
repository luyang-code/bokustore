package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.OrderDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.SettleAccountDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.SettleAccountParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserIdAndBookIdsDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.*;
import com.tsc.graduateproj.bokubookstore.domain.model.*;
import com.tsc.graduateproj.bokubookstore.domain.service.IOrderService;
import com.tsc.graduateproj.bokubookstore.enums.ExceptionEnum;
import com.tsc.graduateproj.bokubookstore.infrastructure.*;
import com.tsc.graduateproj.bokubookstore.util.ExceptionUtil;
import com.tsc.graduateproj.bokubookstore.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IPictureRepository pictureRepository;

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public OrderWithCountVO findOrderListByUserId(Integer page,Integer size,String userId) {
        List<OrderDO> orderDOS = orderRepository.findbyUserId(userId);
        List<OrderVO> orderVOList = orderDOS.stream().map(orderDO->{
            UserDO userDO = userRepository.findByUserId(orderDO.getCustomId());
//            String address = addressRepository.findByAddressId(orderDO.getAddressId()).getAddress();
            BookDO bookDO = bookRepository.findByBookId(orderDO.getBookId());
            List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(orderDO.getBookId()).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
            String mainPic="";
            if(!ListUtils.isEmpty(pictureDOS)) mainPic=pictureDOS.get(0).getBookPicture();
            return new OrderVO(orderDO,userDO,bookDO,mainPic);
        }).collect(Collectors.toList());
        return new OrderWithCountVO(orderVOList.size(),ListUtils.page(orderVOList,page,size));
    }

    @Override
    public OrderVO findByOrderNumber(String orderNumber) {
        OrderDO orderDO = orderRepository.findByOrderNumber(orderNumber);
        UserDO userDO = userRepository.findByUserId(orderDO.getCustomId());
        String address = addressRepository.findByAddressId(orderDO.getAddressId()).getAddress();
        BookDO bookDO = bookRepository.findByBookId(orderDO.getBookId());
        List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(orderDO.getBookId()).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
        String mainPic="";
        if(!ListUtils.isEmpty(pictureDOS)) mainPic=pictureDOS.get(0).getBookPicture();
        return new OrderVO(orderDO,userDO,bookDO,mainPic);
    }

    @Transactional
    @Override
    public Boolean saveBooksToOrder(SettleAccountParamDTO settleAccountParamDTO) {
        settleAccountParamDTO.getSettleAccountDTOS().stream().forEach(settleAccountDTO ->{
            orderRepository.save(new OrderDO(settleAccountParamDTO.getUserId(),settleAccountParamDTO.getAddressId(),settleAccountDTO));
            cartRepository.deleteCartBook(settleAccountParamDTO.getUserId(), settleAccountDTO.getBookId());
        });
        return true;
    }

    @Override
    public List<SettleAccountVO> findBookToSettleAccountPage(UserIdAndBookIdsDTO userIdAndBookIdsDTO) {
        return userIdAndBookIdsDTO.getBookIds().stream().map(bookId->{
            CartDO cartDO = cartRepository.queryByCustomIdAndBookId(userIdAndBookIdsDTO.getUserId(), bookId);
            BookDO bookDO = bookRepository.findByBookId(bookId);
            UserDO user = userRepository.findByUserId(userIdAndBookIdsDTO.getUserId());
            ExceptionUtil.throwException(StringUtils.isEmpty(user), ExceptionEnum.NOTLOGIN);
            List<AddressVO> addressVOS=addressRepository.findAddressByUserId(user.getUserId()).stream()
                    .filter(AddressDO::getIsdefault).map(address -> new AddressVO(address)).collect(Collectors.toList());
            AddressVO addressVO=new AddressVO();
            if(!ListUtils.isEmpty(addressVOS)) addressVO=addressVOS.get(0);
            List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(bookId).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
            String mainPic="";
            if(!ListUtils.isEmpty(pictureDOS)) mainPic=pictureDOS.get(0).getBookPicture();
            return new SettleAccountVO(cartDO,mainPic,bookDO,addressVO);
        }).collect(Collectors.toList());
    }

}