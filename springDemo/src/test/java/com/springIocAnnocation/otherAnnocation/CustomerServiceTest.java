package com.springIocAnnocation.otherAnnocation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.*;

public class CustomerServiceTest {
    //spring注解方式配置生命周期
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_annocation.xml");
        CustomerService customerService = (CustomerService) classPathXmlApplicationContext.getBean("customerService");
        customerService.save();
        classPathXmlApplicationContext.close();
    }

    //spring注解方式配置scope
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_annocation.xml");
        CustomerService customerService = (CustomerService) classPathXmlApplicationContext.getBean("customerService");
        CustomerService customerService1 = (CustomerService) classPathXmlApplicationContext.getBean("customerService");
        System.out.println(customerService == customerService1);

    }
}