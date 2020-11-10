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
@Table(name = "account")
public class TAccount {
    /**
     * 账户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 币种
     */
    private String currency;

    /**
     * 账户余额
     */
    private Long amount;

    /**
     * 冻结金额
     */
    @Column(name = "frz_amount")
    private Long frzAmount;

    /**
     * 可用金额
     */
    @Column(name = "avl_amount")
    private Long avlAmount;

    /**
     * 权限(各个位置1-允许)：透支，冻结，只入金，只出金，转账。
     */
    private String permission;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否锁定：1-是；0-否
     */
    @Column(name = "is_locked")
    private Boolean isLocked;

    /**
     * 是否启用：1-是；0-否
     */
    @Column(name = "is_active")
    private Boolean isActive;


}