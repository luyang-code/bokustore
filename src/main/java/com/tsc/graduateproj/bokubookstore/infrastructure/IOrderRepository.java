package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IOrderRepository extends JpaRepository<OrderDO,Integer>, JpaSpecificationExecutor<OrderDO> {

    @Query("select o from OrderDO o where o.customId=?1 and o.isdelete=false ")
    List<OrderDO> findbyUserId(String userId);

    @Query("select o from OrderDO o where o.orderNumber=?1 and o.isdelete=false ")
    OrderDO findByOrderNumber(String orderNumber);

}
