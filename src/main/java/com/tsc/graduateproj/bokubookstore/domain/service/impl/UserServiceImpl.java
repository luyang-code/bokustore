package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.UserLoginDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserRegistDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserVO;
import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import com.tsc.graduateproj.bokubookstore.domain.service.IUserService;
import com.tsc.graduateproj.bokubookstore.infrastructure.IUserRepository;
import com.tsc.graduateproj.bokubookstore.enums.ExceptionEnum;
import com.tsc.graduateproj.bokubookstore.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserVO  userLogin(UserLoginDTO userLoginDTO) {
        //判断是否注册
        UserDO userDO = userRepository.findByUserName(userLoginDTO.getUserName());
        ExceptionUtil.throwException(StringUtils.isEmpty(userDO), ExceptionEnum.USER_NOT_REGIST);
        //判断用户名密码是否正确
        UserDO user = userRepository.findByUserNameAndPassword(userLoginDTO.getUserName(), userLoginDTO.getUserPassword());
        ExceptionUtil.throwException(StringUtils.isEmpty(user), ExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        return new UserVO(user);
    }

    @Override
    public Boolean userRegist(UserRegistDTO userRegistDTO) {
        //判断是否注册
        UserDO user = userRepository.findByUserName(userRegistDTO.getUserName());
        ExceptionUtil.throwException(!StringUtils.isEmpty(user), ExceptionEnum.USER_NAME_EXIST);
        Integer id;
        if(userRepository.queryNum()==0){
            id=101;
        }else {
            id = Integer.parseInt(userRepository.findLastUser(PageRequest.of(0, 1)).getUserId().substring(1)) + 1;
        }
        userRepository.save(new UserDO(userRegistDTO,id));
        return true;
    }
}
