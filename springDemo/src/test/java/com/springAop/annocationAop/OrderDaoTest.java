package com.springAop.annocationAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * springAop注解开发
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_aopAnnocation.xml")
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;
    @Test
    public void test() {
        orderDao.save();
        orderDao.delete();
        orderDao.find();
        orderDao.update();
    }

}