package com.mypay.account.api;

public interface TransactionApi {
    /**
     * 冻结
     */
    void freeze();

    /**
     * 解冻
     */
    void unfreeze();

    /**
     * 入账
     */
    void credit();

    /**
     * 入账后冻结
     */
    void freezeCredit();

    /**
     * 出账
     */
    void debit();

    /**
     * 解冻后出账
     */
    void unfreezeDebit();

    /**
     * 转账
     */
    void debitAndCredit();

    /**
     * 转账后冻结
     */
    void debitAndFreezeCredit();

    /**
     * 解冻后转账
     */
    void unfreezeDebitAndCredit();

    /**
     * 解冻后转账，再冻结
     */
    void unfreezeDebitAndFreezeCredit();
}
