package com.springIocXmlAndAnnocation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * spring 使用xml和注解整合开发
 */
public class ProductService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    public void save(){
        System.out.println("productservice 中的save方法执行.....");
        orderDao.save();
        productDao.save();
    }
}
