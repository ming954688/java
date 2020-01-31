package com.springDemo1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTest {

    //传统方式调用:
    @Test
    public void test(){
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setName("ming");
        userDao.save();
    }


    //spring方式的调用
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) classPathXmlApplicationContext.getBean("userDao");
        userDao.save();
    }
}