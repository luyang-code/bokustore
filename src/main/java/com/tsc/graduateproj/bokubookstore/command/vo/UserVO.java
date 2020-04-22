package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.UserDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("手机号")
    private String userPhone;

    @ApiModelProperty("性别")
    private String userSex;

    public UserVO(UserDO userDO){
        this.userId=userDO.getUserId();
        this.userName=userDO.getUserName();
        this.userPassword=userDO.getUserPassword();
        this.userPhone=userDO.getUserPhone();
        this.userSex=userDO.getUserSex();
    }

}
