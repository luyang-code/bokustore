package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.CartDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.CartVO;
import com.tsc.graduateproj.bokubookstore.command.vo.CartWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.service.ICartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bokustore/cart")
@Api(value = "CartController", tags = {"购物车"})
public class CartController {

    @Autowired
    private ICartService cartService;

    @ApiOperation("查询购物车信息")
    @GetMapping("/allCart/{page}/{size}/{customId}")
    public CartWithCountVO queryAllShopCartByCustomId(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@PathVariable("customId") String customId){
        return cartService.queryAllShopCartByCustomId(page,size,customId);
    }

    @ApiOperation("将商品加入购物车")
    @PostMapping("/addToCart")
    public Boolean addToShopCart(@RequestBody CartDTO cartDTO){
        return cartService.addToShopCart(cartDTO);
    }

    @ApiOperation("删除购物车中的商品")
    @PostMapping("/deleteCartBook/{customId}/{bookId}")
    public Boolean deleteShopCartBook(@PathVariable("customId") String customId,@PathVariable("bookId") String bookId){
        return cartService.deleteShopCartBook(customId,bookId);
    }

    @ApiOperation("修改购物车中的商品")
    @PostMapping("/modifyCartBook")
    public Boolean modifyShopCartBook(@RequestBody CartDTO cartDTO){
        return cartService.modifyShopCartBook(cartDTO);
    }

}
