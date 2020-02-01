package com.springAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_aop.xml")
public class ProductDaoImplTest {
    @Resource(name = "productDao1")
    private ProductDao productDao;

    @Test
    public void test(){
        productDao.find();
        productDao.save();
    }
}