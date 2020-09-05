package com.tsc.graduateproj.bokubookstore.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "deal_info")
@AllArgsConstructor
@NoArgsConstructor
public class DealInfoDO {
    @Id
    @GenericGenerator(name = "autoId",strategy = "native")
    @GeneratedValue(generator = "autoId")
    private Integer id;

    @ApiModelProperty("成交表id")
    private Integer dealId;
    @ApiModelProperty("行政区名称")
    private String district;
    @ApiModelProperty("行政区id")
    private Integer districtId;
    @ApiModelProperty("商圈名称")
    private String region;
    @ApiModelProperty("商圈id")
    private Integer bizAreaId;
    @ApiModelProperty("小区名称")
    private String community;
    @ApiModelProperty("小区id")
    private Integer communityId;
    @ApiModelProperty("座栋ID")
    private Integer blockId;
    @ApiModelProperty("座栋名称")
    private String block;
    @ApiModelProperty("单元名称")
    private String unitName;
    @ApiModelProperty("单元ID")
    private Integer unitId;
    @ApiModelProperty("房间号")
    private String roomCode;
    @ApiModelProperty("房间ID")
    private Integer roomId;
    @ApiModelProperty("房屋用途")
    private String purpose;
    @ApiModelProperty("产权性质")
    private String property;
    @ApiModelProperty("室")
    private String room;
    @ApiModelProperty("厅")
    private String livingRoom;
    @ApiModelProperty("卫生间")
    private String washing;
    @ApiModelProperty("阳台")
    private String balcony;
    @ApiModelProperty("面积")
    private Double area;
    @ApiModelProperty("朝向")
    private String direction;
    @ApiModelProperty("楼层")
    private Integer floor;
    @ApiModelProperty("总楼层")
    private Integer topFloor;
    @ApiModelProperty("建筑年代")
    private Integer buildingAge;

    @ApiModelProperty("成交编号")
    private String agreementCode;
    @ApiModelProperty("合同状态")
    private String ustatus;
    @ApiModelProperty("分成状态")
    private String commissionStatus;
    @ApiModelProperty("合同类型")
    private String utype;


    @ApiModelProperty("成交门店id（千家id）")
    private Integer dealDepartmentId;
    @ApiModelProperty("成交人")
    private String dealUsername;
    @ApiModelProperty(" 成交人id（千家id）")
    private Integer dealUserId;

    @ApiModelProperty("成交日期")
    private Date completeDate;
    @ApiModelProperty("合同编号")
    private String completeCode;
    @ApiModelProperty("成交价格")
    private Double payment;
    @ApiModelProperty("成交价格单位")
    private String paymentUtil;
    @ApiModelProperty("应收佣金")
    private Double planPayment;
    @ApiModelProperty("应收佣金单位")
    private String planPaymentUtil;

    @ApiModelProperty("土地证号")
    private String landCertificateNo;
    @ApiModelProperty("产权证号")
    private String propertyRightCertificateNo;

    @ApiModelProperty("权证人id(千家id)")
    private Integer warrantUserId;
    @ApiModelProperty("权证人名称")
    private String warrantUserName;
    @ApiModelProperty("权证人部门id（千家id）")
    private Integer warrantDepartmentId;
    @ApiModelProperty("备注信息")
    private String comment;

    @ApiModelProperty("过户状态")
    private String transferStatus;
    @ApiModelProperty("当前进度")
    private String progressName;

    @ApiModelProperty("租赁开始日期")
    private Date rentStart;
    @ApiModelProperty("租赁到期日期")
    private Date rentEnd;

    @ApiModelProperty("合同应收")
    private Double requiredMoney;
    @ApiModelProperty("中介类佣金实应收")
    private Double expectMoney;
    @ApiModelProperty("佣金已收")
    private Double paidMoney;
    @ApiModelProperty("客户应实收")
    private Double clientExpect;
    @ApiModelProperty("业主实应收")
    private Double ownerExpect;

    @ApiModelProperty("金融类佣金实应收")
    private Double financeExpectMoney;
    @ApiModelProperty("金融类佣金已收")
    private Double financePaidMoney;
    @ApiModelProperty("金融类客户实应收")
    private Double financeClientExpect;
    @ApiModelProperty("金融类业主实应收")
    private Double financeOwnerExpect;

    @ApiModelProperty("结案日期")
    private Date closeDate;
    @ApiModelProperty("佣金结案时间")
    private Date closeCommissionDate;
    @ApiModelProperty("是否佣金结案")
    private String ifCloseCommission;

    @ApiModelProperty("录入门店ID")
    private Integer inputDepartmentId;
    @ApiModelProperty("录入人")
    private String inputUsername;
    @ApiModelProperty("录入人ID")
    private Integer inputUserId;

    @ApiModelProperty("客源ID")
    private Integer clientId;
    @ApiModelProperty("客源编号")
    private String clientCode;
    @ApiModelProperty("客户姓名")
    private String clientName;
    @ApiModelProperty("客户性别")
    private String clientGender;
    @ApiModelProperty("客户身份证号")
    private String clientIdCard;
    @ApiModelProperty("客户地址")
    private String clientAddress;


    @ApiModelProperty("房源ID")
    private Integer houseId;
    @ApiModelProperty("房源编号")
    private String houseCode;
    @ApiModelProperty("业主姓名")
    private String ownerName;
    @ApiModelProperty("业主身份证号")
    private String ownerIdCard;
    @ApiModelProperty("业主地址")
    private String ownerAddress;
    @ApiModelProperty("业主性别")
    private String ownerGender;

    @ApiModelProperty("评估价")
    private Double evaluatingPrice;
    @ApiModelProperty("录入日期")
    private Date inputDate;
    @ApiModelProperty("删除标志")
    private String ifDeleted;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("城市ID")
    private Integer cityId;
    private Integer version;

}
