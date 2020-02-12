package com.mybatisDemo.springWithMybatis.dao;

import com.mybatisDemo.springWithMybatis.pojo.User;

public interface UserDao {
    User selectUserById(Integer id) throws Exception;
}
