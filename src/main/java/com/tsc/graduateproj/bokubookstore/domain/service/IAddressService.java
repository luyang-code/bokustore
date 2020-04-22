package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.AddressDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.AddressVO;
import com.tsc.graduateproj.bokubookstore.domain.model.AddressDO;

import java.util.List;

public interface IAddressService {

    //根据用户id查询收货地址
    List<AddressVO> findAddressByUserId(String userId);

    //通过地址id查询收货地址
    AddressVO findByAddressId(String addressId);

    //添加收货地址
    Boolean addAddress(AddressDTO addressDTO);

    //删除收货地址
    Boolean deleteAddress(String addressId);

}
