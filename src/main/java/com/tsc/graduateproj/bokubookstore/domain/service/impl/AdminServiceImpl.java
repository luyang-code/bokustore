package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.AdminLoginDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.AdminRegistDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.AdminSaveDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.AddressVO;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminVO;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.model.AdminDO;
import com.tsc.graduateproj.bokubookstore.domain.service.IAdminService;
import com.tsc.graduateproj.bokubookstore.infrastructure.IAdminRepository;
import com.tsc.graduateproj.bokubookstore.enums.ExceptionEnum;
import com.tsc.graduateproj.bokubookstore.util.ExceptionUtil;
import com.tsc.graduateproj.bokubookstore.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;

    @Override
    public AdminVO adminLogin(AdminLoginDTO adminLoginDTO) {
        AdminDO adminDo = adminRepository.findByAdminName(adminLoginDTO.getAdminName());
        ExceptionUtil.throwException(StringUtils.isEmpty(adminDo), ExceptionEnum.ADMIN_NOT_REGIST);
        AdminDO admin = adminRepository.findByAdminNameAndPassword(adminLoginDTO.getAdminName(), adminLoginDTO.getAdminPassword());
        ExceptionUtil.throwException(StringUtils.isEmpty(admin), ExceptionEnum.ADMINNAME_OR_PASSWORD_ERROR);
        return new AdminVO(admin);
    }

    @Override
    public Boolean adminRegist(AdminRegistDTO adminRegistDTO) {
        AdminDO admin = adminRepository.findByAdminName(adminRegistDTO.getAdminName());
        ExceptionUtil.throwException(!StringUtils.isEmpty(admin), ExceptionEnum.ADMIN_NAME_EXIST);
        Integer id;
        if(adminRepository.queryNum()==0) {
            id=101;
        }else {
            id = Integer.parseInt(adminRepository.findLastAdmin(PageRequest.of(0,1)).getAdminId().substring(1))+1;
        }
        adminRepository.save(new AdminDO(adminRegistDTO,id));
        return true;
    }

    @Override
    public void saveAdminInfo(AdminSaveDTO dto) {
        AdminDO adminDO = adminRepository.findByAdminId(dto.getAdminId());
        adminDO.setAdminName(dto.getAdminName());
        adminDO.setAdminPassword(dto.getAdminPassword());
        if("0".equals(dto.getAdminSex())){
            adminDO.setAdminSex("男");
        }else {
            adminDO.setAdminSex("女");
        }
        adminRepository.save(adminDO);
    }

    @Override
    public AdminWithCountVO findAdminList(Integer page, Integer size) {
        List<AdminDO> allAdmin = adminRepository.findAllAdmin();
        List<AdminVO> adminVOS = allAdmin.stream().map(admin -> new AdminVO(admin)).collect(Collectors.toList());
        return new AdminWithCountVO(adminVOS.size(), ListUtils.page(adminVOS, page, size));
    }

    @Transactional
    @Override
    public void deleteAdmin(String adminId) {
        adminRepository.deleteByAdminId(adminId);
    }
}
