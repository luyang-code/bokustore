package com.tsc.graduateproj.bokubookstore.command.vo;

import com.tsc.graduateproj.bokubookstore.domain.model.AddressDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddressVO {

    @ApiModelProperty("地址id")
    private String addressId;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("收货人")
    private String receiver;

    @ApiModelProperty("是否为默认地址")
    private Boolean isdefault;

    public AddressVO(AddressDO addressDO){
        this.addressId=addressDO.getAddressId();
        this.address=addressDO.getAddress();
        this.phone=addressDO.getCustomPhone();
        this.receiver=addressDO.getReceiver();
        this.isdefault=addressDO.getIsdefault();
    }

}
