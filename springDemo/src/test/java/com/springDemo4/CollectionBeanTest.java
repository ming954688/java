package com.springDemo4;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {
    /**
     * 数组类型的属性注入
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CollectionBean collectionBean = (CollectionBean) classPathXmlApplicationContext.getBean("collectionBean");
        System.out.println(collectionBean.toString());
    }
}