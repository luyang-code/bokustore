package com.tsc.graduateproj.bokubookstore.command.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserWithCountVO {

    private Integer count;
    private List<UserVO> userVOS;

    public UserWithCountVO(Integer count, List<UserVO> userVOS) {
        this.count = count;
        this.userVOS = userVOS;
    }
}
