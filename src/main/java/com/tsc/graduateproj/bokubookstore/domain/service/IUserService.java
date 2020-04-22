package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.UserLoginDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserRegistDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserVO;

public interface IUserService {

    //用户登录
    UserVO userLogin(UserLoginDTO userLoginDTO);

    //用户注册
    Boolean userRegist(UserRegistDTO userRegistDTO);

}
