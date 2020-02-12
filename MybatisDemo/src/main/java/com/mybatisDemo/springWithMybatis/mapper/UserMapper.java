package com.mybatisDemo.springWithMybatis.mapper;

import com.mybatisDemo.springWithMybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    public List<User> selectAllUsers();
}
