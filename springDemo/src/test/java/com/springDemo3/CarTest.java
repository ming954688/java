package com.springDemo3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

    /**
     * 构造方法方式注入属性
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car)classPathXmlApplicationContext.getBean("car");
        System.out.println(car.toString());
    }

    /**
     * set方法方式注入属性
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car2 car2 = (Car2)classPathXmlApplicationContext.getBean("car2");
        System.out.println(car2.toString());
    }

    /**
     * p名称空间方式注入 car2
     */
    @Test
    public void test2(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car2 car2 = (Car2)classPathXmlApplicationContext.getBean("car2p");
        System.out.println(car2.toString());
    }
}