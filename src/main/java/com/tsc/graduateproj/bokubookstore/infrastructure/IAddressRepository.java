package com.tsc.graduateproj.bokubookstore.infrastructure;

import com.tsc.graduateproj.bokubookstore.domain.model.AddressDO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAddressRepository extends JpaRepository<AddressDO,Integer>, JpaSpecificationExecutor<AddressDO> {

    @Query("select a from AddressDO a where a.customId=?1 and a.isdelete=false ")
    List<AddressDO> findAddressByUserId(String userId);

    @Query("select a from AddressDO a where a.addressId=?1 and a.isdelete=false ")
    AddressDO findByAddressId(String addressId);

    @Modifying
    @Query("update AddressDO a set a.isdelete=true where a.addressId=?1")
    void deleteAddressByAddressId(String addressId);

    @Query("select a from AddressDO a where a.isdelete=false order by a.addressId desc ")
    AddressDO findLastAddress(PageRequest page);

    @Query("select count(a) from AddressDO a where a.isdelete=false ")
    Integer queryNum();

}
