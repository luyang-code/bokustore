package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.OrderParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.SettleAccountParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserIdAndBookIdsDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.*;
import com.tsc.graduateproj.bokubookstore.domain.model.*;
import com.tsc.graduateproj.bokubookstore.domain.service.IOrderService;
import com.tsc.graduateproj.bokubookstore.enums.ExceptionEnum;
import com.tsc.graduateproj.bokubookstore.infrastructure.*;
import com.tsc.graduateproj.bokubookstore.util.DateUtils;
import com.tsc.graduateproj.bokubookstore.util.ExceptionUtil;
import com.tsc.graduateproj.bokubookstore.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.text.ParseException;
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
    public OrderWithCountVO findOrderListByUserId(Integer page, Integer size, String userId) {
        List<OrderDO> orderDOS = orderRepository.findbyUserId(userId);
        List<OrderVO> orderVOList = orderDOS.stream().map(orderDO -> {
            UserDO userDO = userRepository.findByUserId(orderDO.getCustomId());
//            String address = addressRepository.findByAddressId(orderDO.getAddressId()).getAddress();
            BookDO bookDO = bookRepository.findByBookId(orderDO.getBookId());
            List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(orderDO.getBookId()).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
            String mainPic = "";
            if (!ListUtils.isEmpty(pictureDOS)) mainPic = pictureDOS.get(0).getBookPicture();
            return new OrderVO(orderDO, userDO, bookDO, mainPic);
        }).collect(Collectors.toList());
        return new OrderWithCountVO(orderVOList.size(), ListUtils.page(orderVOList, page, size));
    }

    @Override
    public OrderVO findByOrderNumber(String orderNumber) {
        OrderDO orderDO = orderRepository.findByOrderNumber(orderNumber);
        UserDO userDO = userRepository.findByUserId(orderDO.getCustomId());
        String address = addressRepository.findByAddressId(orderDO.getAddressId()).getAddress();
        BookDO bookDO = bookRepository.findByBookId(orderDO.getBookId());
        List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(orderDO.getBookId()).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
        String mainPic = "";
        if (!ListUtils.isEmpty(pictureDOS)) mainPic = pictureDOS.get(0).getBookPicture();
        return new OrderVO(orderDO, userDO, bookDO, mainPic);
    }

    @Transactional
    @Override
    public Boolean saveBooksToOrder(SettleAccountParamDTO settleAccountParamDTO) {
        settleAccountParamDTO.getSettleAccountDTOS().stream().forEach(settleAccountDTO -> {
            orderRepository.save(new OrderDO(settleAccountParamDTO.getUserId(), settleAccountParamDTO.getAddressId(), settleAccountDTO));
            cartRepository.deleteCartBook(settleAccountParamDTO.getUserId(), settleAccountDTO.getBookId());
            BookDO byBookId = bookRepository.findByBookId(settleAccountDTO.getBookId());
            byBookId.setStockCount(byBookId.getStockCount() - settleAccountDTO.getBookCount());
            bookRepository.save(byBookId);
        });
        return true;
    }

    @Override
    public List<SettleAccountVO> findBookToSettleAccountPage(UserIdAndBookIdsDTO userIdAndBookIdsDTO) {
        return userIdAndBookIdsDTO.getBookIds().stream().map(bookId -> {
            CartDO cartDO = cartRepository.queryByCustomIdAndBookId(userIdAndBookIdsDTO.getUserId(), bookId);
            BookDO bookDO = bookRepository.findByBookId(bookId);
            UserDO user = userRepository.findByUserId(userIdAndBookIdsDTO.getUserId());
            ExceptionUtil.throwException(StringUtils.isEmpty(user), ExceptionEnum.NOTLOGIN);
            List<AddressVO> addressVOS = addressRepository.findAddressByUserId(user.getUserId()).stream()
                    .filter(AddressDO::getIsdefault).map(address -> new AddressVO(address)).collect(Collectors.toList());
            AddressVO addressVO = new AddressVO();
            if (!ListUtils.isEmpty(addressVOS)) addressVO = addressVOS.get(0);
            List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(bookId).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
            String mainPic = "";
            if (!ListUtils.isEmpty(pictureDOS)) mainPic = pictureDOS.get(0).getBookPicture();
            return new SettleAccountVO(cartDO, mainPic, bookDO, addressVO);
        }).collect(Collectors.toList());
    }

    @Override
    public OrderWithCountVO findBackOrderListInfo(Integer page, Integer size, String adminId) {
        List<OrderDO> orderDOS = orderRepository.findBackOrderListByAdminId(adminId);
        List<OrderVO> orderVOList = orderDOS.stream().map(orderDO -> {
            UserDO userDO = userRepository.findByUserId(orderDO.getCustomId());
//            String address = addressRepository.findByAddressId(orderDO.getAddressId()).getAddress();
            BookDO bookDO = bookRepository.findByBookId(orderDO.getBookId());
            List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(orderDO.getBookId()).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
            String mainPic = "";
            if (!ListUtils.isEmpty(pictureDOS)) mainPic = pictureDOS.get(0).getBookPicture();
            return new OrderVO(orderDO, userDO, bookDO, mainPic);
        }).collect(Collectors.toList());
        return new OrderWithCountVO(orderVOList.size(), ListUtils.page(orderVOList, page, size));
    }

    @Override
    public OrderWithCountVO searchBackOrderList(Integer page, Integer size, OrderParamDTO dto) {
        List<OrderDO> backOrderListByAdminId = new ArrayList<>();
        if (StringUtils.isEmpty(dto.getKeyWord()) && ListUtils.isEmpty(dto.getOrderTimes())) {
            backOrderListByAdminId.addAll(orderRepository.findBackOrderListByAdminId(dto.getAdminId()));
        } else if (!StringUtils.isEmpty(dto.getKeyWord()) && ListUtils.isEmpty(dto.getOrderTimes())) {
            getOrderList(dto, backOrderListByAdminId);
        } else if (StringUtils.isEmpty(dto.getKeyWord()) && !ListUtils.isEmpty(dto.getOrderTimes())) {
            List<Date> dates = transformDate(dto.getOrderTimes());
            Date start = dates.get(0);
            Date end = dates.get(1);
            backOrderListByAdminId.addAll(orderRepository.findByOrderTimes
                    (dto.getAdminId(), start, end));
        } else {
            List<OrderDO> orderList1 = getOrderList(dto, backOrderListByAdminId);
            List<Date> dates = transformDate(dto.getOrderTimes());
            Date start = dates.get(0);
            Date end = dates.get(1);
            List<OrderDO> orderList2 = orderRepository.findByOrderTimes(dto.getAdminId(), start, end);
            backOrderListByAdminId = orderList1.stream()
                    .filter(item -> orderList2.contains(item)).collect(Collectors.toList());
        }
        List<OrderVO> orderVOList = backOrderListByAdminId.stream().map(orderDO -> {
            UserDO userDO = userRepository.findByUserId(orderDO.getCustomId());
//            String address = addressRepository.findByAddressId(orderDO.getAddressId()).getAddress();
            BookDO bookDO = bookRepository.findByBookId(orderDO.getBookId());
            List<PictureDO> pictureDOS = pictureRepository.findPictureByBookId(orderDO.getBookId()).stream().filter(PictureDO::getMainPic).collect(Collectors.toList());
            String mainPic = "";
            if (!ListUtils.isEmpty(pictureDOS)) mainPic = pictureDOS.get(0).getBookPicture();
            return new OrderVO(orderDO, userDO, bookDO, mainPic);
        }).collect(Collectors.toList());
        return new OrderWithCountVO(orderVOList.size(), ListUtils.page(orderVOList, page, size));
    }

    @Override
    public void modifyOrderState(String orderNumber) {
        OrderDO byOrderNumber = orderRepository.findByOrderNumber(orderNumber);
        byOrderNumber.setOrderState(1);
        orderRepository.save(byOrderNumber);
    }

    //获取订单列表
    private List<OrderDO> getOrderList(OrderParamDTO dto, List<OrderDO> backOrderListByAdminId) {
        List<OrderDO> likeReceiver = orderRepository.findLikeReceiver(dto.getKeyWord(), dto.getAdminId());
        if (!ListUtils.isEmpty(likeReceiver)) backOrderListByAdminId.addAll(likeReceiver);

        List<OrderDO> likePhone = orderRepository.findLikePhone(dto.getKeyWord(), dto.getAdminId());
        if (!ListUtils.isEmpty(likePhone)) backOrderListByAdminId.addAll(likePhone);

        List<OrderDO> likeOrderNumber = orderRepository.findLikeOrderNumber(dto.getKeyWord(), dto.getAdminId());
        if (!ListUtils.isEmpty(likeOrderNumber)) backOrderListByAdminId.addAll(likeOrderNumber);

        List<BookDO> likeBookName = bookRepository.findBookByName(dto.getKeyWord());
        List<String> bookIds = likeBookName.stream().map(BookDO::getBookId).collect(Collectors.toList());
        List<OrderDO> likeBookName1 = orderRepository.findLikeBookName(dto.getAdminId(), bookIds);
        if (!ListUtils.isEmpty(likeBookName1)) backOrderListByAdminId.addAll(likeBookName1);

        List<BookDO> likeBookAuthor = bookRepository.findBookAuthor(dto.getKeyWord());
        List<String> bookId1s = likeBookAuthor.stream().map(BookDO::getBookId).collect(Collectors.toList());
        List<OrderDO> likeBookAuthor1 = orderRepository.findLikeBookName(dto.getAdminId(), bookId1s);
        if (!ListUtils.isEmpty(likeBookAuthor1)) backOrderListByAdminId.addAll(likeBookAuthor1);
        return backOrderListByAdminId;
    }

    //字符串时间区间转换成date
    private List<Date> transformDate(List<String> orderTimes) {
        List<Date> dates = new ArrayList<>();
        Date start, end;
        try {
            start = new SimpleDateFormat(DateUtils.DATETODAY).parse(orderTimes.get(0));
            dates.add(start);
            end = new SimpleDateFormat(DateUtils.DATETODAY).parse(orderTimes.get(1));
            dates.add(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dates;
    }

}