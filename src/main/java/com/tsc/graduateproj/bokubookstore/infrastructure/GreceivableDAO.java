package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.GreceivableDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GreceivableDAO extends JpaRepository<GreceivableDO,Integer> {

    @Query("select d from GreceivableDO d where d.isdelete=false ")
    List<GreceivableDO> findAllReceiveInfo();

    @Query("select d from GreceivableDO d where d.completeCode in (?1) and d.isdelete=false ")
    List<GreceivableDO> findInfoByQueryComplete(List<String> completeCodes);

}
