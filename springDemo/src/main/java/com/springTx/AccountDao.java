package com.springTx;

/**
 * 转战Dao
 */
public interface AccountDao {
    void outMoney(String from,double money);
    void inMoney(String to,double money);
}
