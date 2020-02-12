package com.mybatisDemo.springWithMybatis.mapper;

import com.mybatisDemo.springWithMybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springwithMybatis/applicationContext.xml")
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void demo(){
        List<User> users = userMapper.selectAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}