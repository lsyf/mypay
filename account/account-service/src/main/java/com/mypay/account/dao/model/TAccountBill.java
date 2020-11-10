package com.mypay.account.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_bill")
public class TAccountBill {
    /**
     * 流水id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 账户id
     */
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 类型：in-入账；out-出账
     */
    private String type;

    /**
     * 币种
     */
    private String currency;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 上期余额
     */
    @Column(name = "last_amount")
    private Long lastAmount;

    /**
     * 当前余额
     */
    @Column(name = "current_amount")
    private Long currentAmount;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 业务类型
     */
    @Column(name = "biz_type")
    private String bizType;

    /**
     * 业务关联id
     */
    @Column(name = "biz_id")
    private String bizId;

    /**
     * 业务信息
     */
    @Column(name = "biz_info")
    private String bizInfo;

    /**
     * 备注
     */
    private String remark;


}