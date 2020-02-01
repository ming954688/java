package com.springIocAnnocation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring的ioc的注解开发的测试类
 */
public class UserDaoTest {
    //传统方式
    @Test
    public void test(){
        UserDaoImpl userDao = new UserDaoImpl();
        //传统方式设置值
        //userDao.setName("张三");
        userDao.save();
    }

    //springIoc注解方式
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_annocation.xml");
        UserService service = (UserService) classPathXmlApplicationContext.getBean("userService");
        service.save();
    }

}