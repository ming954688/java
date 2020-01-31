package com.springDemo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerDaoImplTest {

    /**
     * 测试bean的生命周期
     */
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDao dao = (CustomerDao) applicationContext.getBean("CustomerDao");
        dao.save();
        applicationContext.close();
    }

    /**
     * 测试bean的作用范围, 修改spring的配置文件中的scope之后 再次测试一次
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDao dao = (CustomerDao) applicationContext.getBean("CustomerDao");
        CustomerDao dao1 = (CustomerDao) applicationContext.getBean("CustomerDao");
        System.out.println(dao == dao1);
    }
}