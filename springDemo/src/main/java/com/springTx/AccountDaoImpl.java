package com.springTx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 描述: 转账Dao的实现类
 * Author: Ming
 * Date: 2020/2/10 4:00
 * version: 1.0
 */
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void outMoney(String from, double money) {
        jdbcTemplate.update("update account set money = money-? where name = ?",money,from);
    }

    @Override
    public void inMoney(String to, double money) {
        jdbcTemplate.update("update account set money = money+? where name = ?",money,to);
    }
}
