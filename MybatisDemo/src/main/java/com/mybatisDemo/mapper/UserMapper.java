package com.mybatisDemo.mapper;

import com.mybatisDemo.pojo.User;

public interface UserMapper {
    public User selectById(Integer id);
}
