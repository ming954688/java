package com.mybatisDemo.springWithMybatis.dao.impl;

import com.mybatisDemo.springWithMybatis.dao.UserDao;
import com.mybatisDemo.springWithMybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springwithMybatis/applicationContext.xml")
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;
    
    @Test
    public void demo() throws Exception {
        User user = userDao.selectUserById(1);
        System.out.println(user);
    }
}