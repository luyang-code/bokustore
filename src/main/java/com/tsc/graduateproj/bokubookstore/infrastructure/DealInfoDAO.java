package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.DealInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DealInfoDAO extends JpaRepository<DealInfoDO,Integer> {

    @Query("select d from DealInfoDO d where d.ifDeleted='0' ")
    List<DealInfoDO> findAllDealInfo();

}
