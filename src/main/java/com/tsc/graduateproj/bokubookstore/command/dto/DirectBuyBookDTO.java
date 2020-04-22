package com.tsc.graduateproj.bokubookstore.command.dto;

import com.tsc.graduateproj.bokubookstore.command.vo.AddressVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DirectBuyBookDTO {

    private String userId;

    private String bookId;

    private Integer count;

}
