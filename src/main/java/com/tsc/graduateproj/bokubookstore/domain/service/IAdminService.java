package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.AdminLoginDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.AdminRegistDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.AdminSaveDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserSaveDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminVO;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminWithCountVO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserVO;

import java.util.List;

public interface IAdminService {

    //商家登录
    AdminVO adminLogin(AdminLoginDTO adminLoginDTO);

    //商家注册
    Boolean adminRegist(AdminRegistDTO adminRegistDTO);

    void saveAdminInfo(AdminSaveDTO dto);

    AdminWithCountVO findAdminList(Integer page, Integer size);

    void deleteAdmin(String adminId);

}
