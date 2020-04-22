package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.AddressDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.AddressVO;
import com.tsc.graduateproj.bokubookstore.domain.model.AddressDO;
import com.tsc.graduateproj.bokubookstore.domain.service.IAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bokustore/address")
@Api(value = "AddressController", tags = {"地址"})
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @ApiOperation("根据用户id查询收货地址")
    @GetMapping("/findOrderListByUserId/{userId}")
    public List<AddressVO> findOrderListByUserId(@PathVariable("userId") String userId){
        return addressService.findAddressByUserId(userId);
    }

    @ApiOperation("通过地址id查询收货地址")
    @GetMapping("/findByAddressId/{addressId}")
    public AddressVO findByAddressId(@PathVariable("addressId") String addressId){
        return addressService.findByAddressId(addressId);
    }

    @ApiOperation("添加收货地址")
    @PostMapping("/addAddress")
    public Boolean addAddress(@RequestBody AddressDTO addressDTO){
        return addressService.addAddress(addressDTO);
    }

    @ApiOperation("删除收货地址")
    @PostMapping("/deleteAddress/{addressId}")
    public Boolean deleteAddress(@PathVariable("addressId") String addressId){
        return addressService.deleteAddress(addressId);
    }

}
