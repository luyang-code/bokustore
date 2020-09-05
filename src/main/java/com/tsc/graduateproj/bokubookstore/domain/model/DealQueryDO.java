package com.tsc.graduateproj.bokubookstore.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 当月有变更 才会有当月分成数据
 */
@Getter
@Setter
@Entity
@Table(name = "deal_query")
@Accessors(chain = true)
public class DealQueryDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("成交编号")
    private String completeCode;

    @ApiModelProperty("成交日期")
    private Date completeDate;

    @ApiModelProperty("小区名称")
    private String community;

    @ApiModelProperty("小区id")
    private Integer communityId;

    @ApiModelProperty("新人补贴")
    private Boolean subsidy;

    @ApiModelProperty("成交价格")
    private BigDecimal payment;

    @ApiModelProperty("实收金额")
    private BigDecimal paidMoney = BigDecimal.ZERO;

    @ApiModelProperty("应收金额")
    private BigDecimal requiredMoney = BigDecimal.ZERO;

    @ApiModelProperty("分成状态 字典表")
    private Integer dividedState;

    @ApiModelProperty("收款状态")
    private Integer receivablesState;

    @ApiModelProperty("其他收款（元）")
    private BigDecimal otherCollection;

    @ApiModelProperty("待结月份")
    private String waitMonth;

    @ApiModelProperty("待结原因")
    private String reason;

    @ApiModelProperty("成交类型")
    private String utype;
    /**
     * 根据分成月份查询时使用  默认查询当前分成月份
     */
    @ApiModelProperty("分成月份")
    private String divideMonth;

    @ApiModelProperty("报账日期 收佣日期")
    private Date commissionTime;

    @ApiModelProperty("贷款业绩")
    private BigDecimal loanPerformance;

    @ApiModelProperty("是否有历史")
    private Boolean hasHistory;
    /**
     * 结账前提为 以计算
     */
    @ApiModelProperty("是否结账")
    private Boolean isSettleAccounts;

    @ApiModelProperty("是否结过账")
    private Boolean checkHistory;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("运营模式-996-boss-995")
    private Integer operatingModel;

    @ApiModelProperty("是否加盟")
    private Boolean isjoin;

    @ApiModelProperty("成交状态")
    private Integer dealState;

    @ApiModelProperty("修改人名称")
    private String modifiername;

    @ApiModelProperty("贷款业绩锁")
    private Boolean loanPerformanceLock;

    @ApiModelProperty("实收锁")
    private Boolean paidMoneyLock = false;

    @ApiModelProperty("计算标识")
    private Boolean calculateState = false;

    @ApiModelProperty("录入时间")
    private Date entryTime ;

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

    //加盟店报账，实收佣金不可编辑
    private Boolean paidModify = false;


}
