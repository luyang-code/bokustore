package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "g_receivable")
@AllArgsConstructor
@NoArgsConstructor
public class GreceivableDO {

    @Id
    @GenericGenerator(name = "autoId",strategy = "native")
    @GeneratedValue(generator = "autoId")
    private Integer id;

    @ApiModelProperty("部门id")
    private Integer deptId;

    @ApiModelProperty("单据类型(系统默认=一手应收，不可二次编辑)")
    private String receiptType;

    @ApiModelProperty("单据状态(未收款or已结清)")
    private String receiptStatus;

    @ApiModelProperty("单据属性(创建方式:系统生成,手动创建)")
    private String receiptAttribute;

    @ApiModelProperty("应收金额")
    private BigDecimal receivableMoney;

    @ApiModelProperty("费用类型")
    private String costType;

    @ApiModelProperty("应收余额(自动取值,初始＝应收金额)")
    private BigDecimal receivableBalance;

    @ApiModelProperty("业务应收(对应ERP---应收佣金，此数值只展示，不参与任何业务处理计算过程。根据推送生成默认值)")
    private BigDecimal businessReceivable;

    @ApiModelProperty("房源编号")
    private String houseCode;

    @ApiModelProperty("成交编号")
    private String completeCode;

    @ApiModelProperty("成交日期")
    private Date completeDate;

    @ApiModelProperty("成交人id(对应ERP---分成-经纪人，根据推送生成默认值)")
    private Integer completePeopleId;

    @ApiModelProperty("成交店面id")
    private Integer completeDepartmentId;

    @ApiModelProperty("成交价格")
    private BigDecimal completePayment;

    @ApiModelProperty("提佣比例")
    private BigDecimal commissionRatio;

    @ApiModelProperty("小区名称")
    private String blockName;

    @ApiModelProperty("房屋信息")
    private String houseInfo;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("经手人id(责任人)")
    private Integer responsibilityPeopleId;

    @ApiModelProperty("录入日期")
    private Date inputDate;

    @ApiModelProperty("录入人id")
    private Integer inputUserId;

    @ApiModelProperty("单据号")
    private String billNumber;

    @ApiModelProperty("创建天")
    private String createDay;

    @ApiModelProperty("项目id")
    private Integer item_id;

    @ApiModelProperty("发票状态")
    private String invoiceStatus;

    @ApiModelProperty("客户姓名")
    private String clientName;

    @ApiModelProperty("小区id")
    private Integer blockNameId;

    @ApiModelProperty("是否网签")
    private Boolean netSign;

    @ApiModelProperty("确认网签操作时间")
    private Date signDate;

    @ApiModelProperty("确认网签操作人")
    private Integer signOperator;

    @ApiModelProperty("取消网签时间")
    private Date cancleSignDate;

    @ApiModelProperty("取消网签操作人")
    private Integer cancleSignOperator;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    @Column(updatable = false)
    private Date createtime;

    private Integer operatorid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @UpdateTimestamp
    private Date modifytime;

    private Integer modifierid;

    private Boolean isdelete = false;

}
