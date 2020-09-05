package com.tsc.graduateproj.bokubookstore.controller;

import com.tsc.graduateproj.bokubookstore.command.dto.*;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminVO;
import com.tsc.graduateproj.bokubookstore.command.vo.AdminWithCountVO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserVO;
import com.tsc.graduateproj.bokubookstore.command.vo.UserWithCountVO;
import com.tsc.graduateproj.bokubookstore.domain.service.IAdminService;
import com.tsc.graduateproj.bokubookstore.domain.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserVO userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.userLogin(userLoginDTO);
    }

    @ApiOperation("用户注册")
    @PostMapping("/user/regist")
    public Boolean userRegist(@RequestBody UserRegistDTO userDTO) {
        return userService.userRegist(userDTO);
    }

    @ApiOperation("商家登录")
    @PostMapping("/admin/login")
    public AdminVO adminLogin(@RequestBody AdminLoginDTO adminLoginDTO) {
        return adminService.adminLogin(adminLoginDTO);
    }

    @ApiOperation("商家注册")
    @PostMapping("/admin/regist")
    public Boolean adminRegist(@RequestBody AdminRegistDTO adminRegistDTO) {
        return adminService.adminRegist(adminRegistDTO);
    }

    @ApiOperation("修改用户信息并保存")
    @PostMapping("/user/saveUserInfo")
    public void saveUserInfo(@RequestBody UserSaveDTO userSaveDTO) {
        userService.saveUserInfo(userSaveDTO);
    }

    @ApiOperation("修改商家信息并保存")
    @PostMapping("/admin/saveAdminInfo")
    public void saveAdminInfo(@RequestBody AdminSaveDTO adminSaveDTO) {
        adminService.saveAdminInfo(adminSaveDTO);
    }

    @ApiOperation("商家信息查询")
    @GetMapping("/admin/findAdminList/{page}/{size}")
    public AdminWithCountVO findAdminList(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return adminService.findAdminList(page, size);
    }

    @ApiOperation("商家信息删除")
    @GetMapping("/admin/deleteAdmin/{adminId}")
    public void deleteAdmin(@PathVariable("adminId") String adminId) {
        adminService.deleteAdmin(adminId);
    }

    @ApiOperation("用户信息查询")
    @GetMapping("/user/findUserList/{page}/{size}")
    public UserWithCountVO findUserList(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return userService.findUserList(page, size);
    }

    @ApiOperation("用户信息删除")
    @GetMapping("/user/deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
    }

}
