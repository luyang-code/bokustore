package com.tsc.graduateproj.bokubookstore.command.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleAccountParamDTO {

    private String userId;

    private String addressId;

    private List<SettleAccountDTO> settleAccountDTOS;

}
