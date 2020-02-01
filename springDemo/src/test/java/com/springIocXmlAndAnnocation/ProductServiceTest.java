package com.springIocXmlAndAnnocation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ProductServiceTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_xmlAndAnnocation.xml");
        ProductService productService = (ProductService) classPathXmlApplicationContext.getBean("productService");
        productService.save();
    }

}