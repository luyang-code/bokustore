package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.OrderParamDTO;
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

import javax.validation.Valid;
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


    @ApiOperation("商家后台订单管理列表")
    @GetMapping("/backOrderListInfo/{page}/{size}/{adminId}")
    public OrderWithCountVO backOrderListInfo(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@PathVariable("adminId")String adminId){
        return orderService.findBackOrderListInfo(page,size,adminId);
    }

    //可输入买家姓名或订单号或书名或作者
    @ApiOperation("模糊搜索商家后台订单-可输入买家姓名或订单号或书名或作者,还可输入时间区间")
    @PostMapping("/searchBackOrderList/{page}/{size}")
    public OrderWithCountVO searchBackOrderList(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@RequestBody @Valid OrderParamDTO dto){
        return orderService.searchBackOrderList(page,size,dto);
    }

    @ApiOperation("修改订单发货状态")
    @GetMapping("/modifyOrderState/{orderNumber}")
    public void modifyOrderState(@PathVariable("orderNumber") String orderNumber){
        orderService.modifyOrderState(orderNumber);
    }

}
