package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.DealQueryDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DealQueryDAO extends JpaRepository<DealQueryDO,Integer> {

    @Query("select d from DealQueryDO d where d.isdelete=false ")
    List<DealQueryDO> findAllCompleteInfo();

    @Query("select d from DealQueryDO d where d.completeCode in (?1) and d.isdelete=false ")
    List<DealQueryDO> findByReceiveCompleteCodes(List<String> completeCodes);

}
