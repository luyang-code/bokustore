package com.tsc.graduateproj.bokubookstore.domain.service;

import com.tsc.graduateproj.bokubookstore.command.dto.UserLoginDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserRegistDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserSaveDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserVO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserWithCountVO;

import java.util.List;

public interface IUserService {

    //用户登录
    UserVO userLogin(UserLoginDTO userLoginDTO);

    //用户注册
    Boolean userRegist(UserRegistDTO userRegistDTO);

    void saveUserInfo(UserSaveDTO dto);

    UserWithCountVO findUserList(Integer page, Integer size);

    void deleteUser(String userId);


}
