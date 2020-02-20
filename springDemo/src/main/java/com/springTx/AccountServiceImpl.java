package com.springTx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 描述: 这是转账的业务成实现
 * Author: Ming
 * Date: 2020/2/10 3:26
 * version: 1.0
 */
public class AccountServiceImpl implements AccountService {
    /**
     * 
     * @描述:
     * @param from : 转出账号
     * @param to   : 转入账号
     * @param money: 转账金额
     * @return void
     * @author Ming
     * @date 2020/2/10 3:58
     */
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(final String from, final String to, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                accountDao.outMoney(from,money);
                int i = 1/0;
                accountDao.inMoney(to,money);
            }
        });

    }
}
