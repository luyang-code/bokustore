package com.tsc.graduateproj.bokubookstore.command.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AdminWithCountVO {

    private Integer count;
    private List<AdminVO> adminVOS;

    public AdminWithCountVO(Integer count, List<AdminVO> adminVOS) {
        this.count = count;
        this.adminVOS = adminVOS;
    }

}
