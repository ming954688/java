package com.mybatisDemo.mapper;

import com.mybatisDemo.pojo.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OrdersMapperTest {

    SqlSessionFactory factory = null;
    @Before
    public void beforeTest() throws IOException {

        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //创建sqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        factory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    @Test
    public void demo(){
        SqlSession sqlSession = factory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = mapper.selectAllOrders();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }
    
    /**
     * 
     * @描述: 一对一关联查询测试
     * @param 
     * @return void
     * @author Ming
     * @date 2020/2/12 23:35
     */
    @Test
    public void demo1(){
        SqlSession sqlSession = factory.openSession();
        OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> orders = mapper.selectOrders();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }
}