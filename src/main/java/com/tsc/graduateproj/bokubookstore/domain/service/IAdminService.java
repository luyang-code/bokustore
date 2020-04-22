package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.AdminLoginDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.AdminRegistDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminVO;

public interface IAdminService {

    //商家登录
    AdminVO adminLogin(AdminLoginDTO adminLoginDTO);

    //商家注册
    Boolean adminRegist(AdminRegistDTO adminRegistDTO);

}
