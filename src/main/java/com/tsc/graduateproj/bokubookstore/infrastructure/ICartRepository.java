package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.CartDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICartRepository extends JpaRepository<CartDO,Integer>, JpaSpecificationExecutor<CartDO> {

    //根据顾客id查询购物车商品
    @Query("select c from CartDO c where c.customId=?1 and c.isdelete=false ")
    List<CartDO> queryAllShopCartByCustomId(String customId);

    //根据顾客id和图书id查询商品
    @Query("select c from CartDO c where c.customId=?1 and c.bookId=?2 and c.isdelete=false ")
    CartDO queryByCustomIdAndBookId(String customId,String bookId);

    //删除购物车图书信息
    @Modifying
    @Query("update CartDO c set c.isdelete=true where c.customId=?1 and c.bookId=?2 ")
    void deleteCartBook(String customId,String bookId);

}
