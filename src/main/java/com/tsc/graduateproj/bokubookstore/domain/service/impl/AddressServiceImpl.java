package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.AddressDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.AddressVO;
import com.tsc.graduateproj.bokubookstore.domain.model.AddressDO;
import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import com.tsc.graduateproj.bokubookstore.domain.service.IAddressService;
import com.tsc.graduateproj.bokubookstore.infrastructure.IAddressRepository;
import com.tsc.graduateproj.bokubookstore.infrastructure.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<AddressVO> findAddressByUserId(String userId) {
        List<AddressDO> addressDOs = addressRepository.findAddressByUserId(userId);
        return addressDOs.stream().map(AddressVO::new).collect(Collectors.toList());
    }

    @Override
    public AddressVO findByAddressId(String addressId) {
        return new AddressVO(addressRepository.findByAddressId(addressId));
    }

    @Override
    public Boolean addAddress(AddressDTO addressDTO) {
//        UserDO costomer = userRepository.findByUserId(addressDTO.getCustomId());
        Integer id;
        if(addressRepository.queryNum()==0){
            id=101;
        }else {
            id = Integer.parseInt(addressRepository.findLastAddress(PageRequest.of(0, 1)).getAddressId().substring(3)) + 1;
        }
        addressRepository.save(new AddressDO(addressDTO,id));
        return true;
    }

    @Transactional
    @Override
    public Boolean deleteAddress(String addressId) {
        addressRepository.deleteAddressByAddressId(addressId);
        return true;
    }
}
