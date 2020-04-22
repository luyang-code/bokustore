package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.CartDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.CartVO;
import com.tsc.graduateproj.bokubookstore.command.vo.CartWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.model.CartDO;

import java.util.List;

public interface ICartService {

    //购物车清单查看
    CartWithCountVO queryAllShopCartByCustomId(Integer page,Integer size,String customId);

    //将商品加入购物车
    Boolean addToShopCart(CartDTO cartDTO);

    //删除购物车中的商品
    Boolean deleteShopCartBook(String customId,String bookId);

    //修改购物车中的商品
    Boolean modifyShopCartBook(CartDTO cartDTO);

}
