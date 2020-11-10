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
@Table(name = "account_freeze")
public class TAccountFreeze {
    /**
     * 冻结id
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
     * 是否冻结：1-是；0-解冻
     */
    @Column(name = "is_freeze")
    private Byte isFreeze;

    /**
     * 币种
     */
    private String currency;

    /**
     * 冻结金额
     */
    private Long amount;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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