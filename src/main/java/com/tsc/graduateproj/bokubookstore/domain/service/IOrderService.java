package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.OrderDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.SettleAccountDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.SettleAccountParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserIdAndBookIdsDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.*;

import java.util.List;

public interface IOrderService {

    //根据用户id查询订单
    OrderWithCountVO findOrderListByUserId(Integer page,Integer size,String userId);

    //根据订单号查询订单
    OrderVO findByOrderNumber( String orderNumber);

    //保存商品到订单表
    Boolean saveBooksToOrder(SettleAccountParamDTO settleAccountParamDTO);

    //根据顾客id和图书id集合查出已选中商品的信息，并显示在结账页面
    List<SettleAccountVO> findBookToSettleAccountPage(UserIdAndBookIdsDTO userIdAndBookIdsDTO);

}
