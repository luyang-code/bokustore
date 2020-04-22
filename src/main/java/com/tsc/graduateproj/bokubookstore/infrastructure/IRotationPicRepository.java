package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.RotationPicDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRotationPicRepository extends JpaRepository<RotationPicDO,Integer>, JpaSpecificationExecutor<RotationPicDO> {

    @Query("select r from RotationPicDO r where r.isdelete=false ")
    List<RotationPicDO> queryRotationPic();

}
