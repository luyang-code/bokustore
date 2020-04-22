package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.*;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminVO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserVO;
import com.tsc.graduateproj.bokubookstore.domain.service.IAdminService;
import com.tsc.graduateproj.bokubookstore.domain.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginRegist")
@Api(value = "LoginRegistController", tags = {"登录和注册"})
public class LoginRegistController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdminService adminService;

    @ApiOperation("用户登录")
    @PostMapping("/user/login")
    public UserVO userLogin(@RequestBody UserLoginDTO userLoginDTO){
        return userService.userLogin(userLoginDTO);
    }

    @ApiOperation("用户注册")
    @PostMapping("/user/regist")
    public Boolean userRegist(@RequestBody UserRegistDTO userDTO){
        return userService.userRegist(userDTO);
    }

    @ApiOperation("商家登录")
    @PostMapping("/admin/login")
    public AdminVO adminLogin(@RequestBody AdminLoginDTO adminLoginDTO){
        return adminService.adminLogin(adminLoginDTO);
    }

    @ApiOperation("商家注册")
    @PostMapping("/admin/regist")
    public Boolean adminRegist(@RequestBody AdminRegistDTO adminRegistDTO){
        return adminService.adminRegist(adminRegistDTO);
    }

}
