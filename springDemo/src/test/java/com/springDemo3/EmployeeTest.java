package com.springDemo3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeTest {

    /**
     * set对象方式注入对象类型
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee = (Employee)classPathXmlApplicationContext.getBean("employee");
        System.out.println(employee.toString());

    }

    /**
     * 构造方法方式注入对象类型的属性
     */
    @Test
    public void test2(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee2 employee2 = (Employee2) classPathXmlApplicationContext.getBean("employee2");
        System.out.println(employee2.toString());
    }

}