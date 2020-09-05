package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.AdminDO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAdminRepository extends JpaRepository<AdminDO,Integer>,JpaSpecificationExecutor<AdminDO> {

    @Query("select a from AdminDO a where a.adminName=?1 and a.adminPassword=?2 and a.isdelete=false ")
    AdminDO findByAdminNameAndPassword(String adminName,String Password);

    @Query("select a from AdminDO a where a.adminName=?1 and a.isdelete=false ")
    AdminDO findByAdminName(String adminName);

    @Query("select a from AdminDO a where a.isdelete=false order by a.adminId desc ")
    AdminDO findLastAdmin(PageRequest page);

    @Query("select count(a) from AdminDO a where a.isdelete=false ")
    Integer queryNum();

    AdminDO findByAdminId(String adminId);

    @Query("select a from AdminDO a where a.isdelete=false ")
    List<AdminDO> findAllAdmin();

    @Modifying
    @Query("update AdminDO a set a.isdelete=true where a.adminId=?1")
    void deleteByAdminId(String adminId);


}
