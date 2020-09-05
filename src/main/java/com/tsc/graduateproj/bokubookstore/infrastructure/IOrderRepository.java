package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.BookDO;
import com.tsc.graduateproj.bokubookstore.domain.model.OrderDO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IOrderRepository extends JpaRepository<OrderDO, Integer>, JpaSpecificationExecutor<OrderDO> {

    @Query("select o from OrderDO o where o.customId=?1 and o.isdelete=false ")
    List<OrderDO> findbyUserId(String userId);

    @Query("select o from OrderDO o where o.orderNumber=?1 and o.isdelete=false ")
    OrderDO findByOrderNumber(String orderNumber);

    //根据订单查询销量前十图书
    @Query(value = "SELECT o.book_id as bookId,SUM(o.book_count) as sellNum FROM book_order o WHERE o.isdelete=FALSE" +
            " group by o.book_id ORDER BY SUM(o.book_count) DESC limit 10", nativeQuery = true)
    List<Map<String, Integer>> findTopTenBooks();

    //商家后台订单管理列表
    @Query("select o from OrderDO o where o.adminId=?1 and o.isdelete=false ")
    List<OrderDO> findBackOrderListByAdminId(String adminId);


    @Query("select o from OrderDO o where o.receiver like %?1% and o.isdelete=false ")
    List<OrderDO> findLikeReceiver(String keyWord, String adminId);

    @Query("select o from OrderDO o where o.phone like ?1% and o.isdelete=false ")
    List<OrderDO> findLikePhone(String keyWord, String adminId);

    @Query("select o from OrderDO o where o.orderNumber  like ?1% and o.isdelete=false ")
    List<OrderDO> findLikeOrderNumber(String keyWord, String adminId);

    @Query("select o from OrderDO o where o.adminId=?1 and o.bookId in (?2) and o.isdelete=false ")
    List<OrderDO> findLikeBookName(String adminId, List<String> bookIds);

    //按时间区间查询订单
    @Query("select o from OrderDO o where o.adminId=?1 and o.orderTime>=?2 and o.orderTime<=?3 and o.isdelete=false ")
    List<OrderDO> findByOrderTimes(String adminId, Date start, Date end);

}
