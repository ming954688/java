package com.springTx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_tx.xml")
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        accountService.transfer("aa","bb",1000.00);
    }

}