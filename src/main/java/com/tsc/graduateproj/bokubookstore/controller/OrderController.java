package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.SettleAccountParamDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserIdAndBookIdsDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.OrderVO;
import com.tsc.graduateproj.bokubookstore.command.vo.OrderWithCountVO;
import com.tsc.graduateproj.bokubookstore.command.vo.SettleAccountVO;
import com.tsc.graduateproj.bokubookstore.domain.service.IOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bokustore/order")
@Api(value = "OrderController", tags = {"订单"})
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @ApiOperation("根据用户id查询订单")
    @GetMapping("/queryOrderByUserId/{page}/{size}/{userId}")
    public OrderWithCountVO findOrderListByUserId(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@PathVariable("userId") String userId){
        return orderService.findOrderListByUserId(page,size,userId);
    }

    @ApiOperation("根据订单号查询订单")
    @GetMapping("/queryOrderByOrderNum/{orderNumber}")
    public OrderVO findByOrderNumber(@PathVariable("orderNumber") String orderNumber){
        return orderService.findByOrderNumber(orderNumber);
    }

    @ApiOperation("保存商品到订单表")
    @PostMapping("/saveBooksToOrder")
    public Boolean saveBooksToOrder(@RequestBody SettleAccountParamDTO settleAccountParamDTO){
        return orderService.saveBooksToOrder(settleAccountParamDTO);
    }

    @ApiOperation("根据顾客id和图书id集合查出已选中商品的信息，并显示在结账页面")
    @PostMapping("/findBookToSettleAccountPage")
    public List<SettleAccountVO> findBookToSettleAccountPage(@RequestBody UserIdAndBookIdsDTO userIdAndBookIdsDTO){
        return orderService.findBookToSettleAccountPage(userIdAndBookIdsDTO);
    }


}
