package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.*;
import com.tsc.graduateproj.bokubookstore.command.vo.*;

import java.util.List;

public interface IOrderService {

    //根据用户id查询订单
    OrderWithCountVO findOrderListByUserId(Integer page, Integer size, String userId);

    //根据订单号查询订单
    OrderVO findByOrderNumber(String orderNumber);

    //保存商品到订单表
    Boolean saveBooksToOrder(SettleAccountParamDTO settleAccountParamDTO);

    //根据顾客id和图书id集合查出已选中商品的信息，并显示在结账页面
    List<SettleAccountVO> findBookToSettleAccountPage(UserIdAndBookIdsDTO userIdAndBookIdsDTO);

    //商家后台订单管理列表
    OrderWithCountVO findBackOrderListInfo(Integer page, Integer size,String adminId);

    //模糊搜索商家后台订单-可输入买家姓名或订单号或书名或作者,还可输入时间区间
    OrderWithCountVO searchBackOrderList(Integer page, Integer size, OrderParamDTO dto);

    void modifyOrderState(String orderNumber);

}
