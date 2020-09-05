package com.tsc.graduateproj.bokubookstore.domain.service.impl;

import com.tsc.graduateproj.bokubookstore.command.dto.UserLoginDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserRegistDTO;
import com.tsc.graduateproj.bokubookstore.command.dto.UserSaveDTO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserVO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import com.tsc.graduateproj.bokubookstore.domain.service.IUserService;
import com.tsc.graduateproj.bokubookstore.infrastructure.IUserRepository;
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

    @Override
    public void saveUserInfo(UserSaveDTO dto) {
        UserDO userDO = userRepository.findByUserId(dto.getUserId());
        userDO.setUserName(dto.getUserName());
        userDO.setUserPassword(dto.getUserPassword());
        if("0".equals(dto.getUserSex())){
            userDO.setUserSex("男");
        }else {
            userDO.setUserSex("女");
        }
        userRepository.save(userDO);
    }

    @Override
    public UserWithCountVO findUserList(Integer page, Integer size) {
        List<UserDO> allUser = userRepository.findAllUser();
        List<UserVO> userVOS = allUser.stream().map(user -> new UserVO(user)).collect(Collectors.toList());
        return new UserWithCountVO(userVOS.size(),ListUtils.page(userVOS, page, size));
    }

    @Transactional
    @Override
    public void deleteUser(String userId) {
        userRepository.deleteByUserId(userId);
    }
}
