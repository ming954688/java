package com.mybatisDemo.springWithMybatis.dao.impl;

import com.mybatisDemo.springWithMybatis.dao.UserDao;
import com.mybatisDemo.springWithMybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 描述: 传统dao开发
 * Author: Ming
 * Date: 2020/2/13 1:01
 * version: 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSessionFactoryBean sessionFactoryBean;

    @Override
    public User selectUserById(Integer id) throws Exception {
        SqlSessionFactory object = sessionFactoryBean.getObject();
        SqlSession sqlSession = object.openSession();
        Connection connection = sqlSession.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();

        User user = new User();
        while (resultSet.next()){
            int id1 = resultSet.getInt("id");
            String username = resultSet.getString("username");
            user.setId(id1);
            user.setUsername(username);
        }
        return user;
    }
}
