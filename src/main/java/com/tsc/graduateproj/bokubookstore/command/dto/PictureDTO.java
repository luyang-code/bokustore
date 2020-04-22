package com.tsc.graduateproj.bokubookstore.command.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PictureDTO {

    //图片路径
    private String pictureUrl;

    //是否为主图
    private Boolean mainPic;

    public PictureDTO(String pictureUrl,Boolean mainPic){
        this.pictureUrl=pictureUrl;
        this.mainPic=mainPic;
    }

}
