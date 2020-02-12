package com.mybatisDemo.mapper;

import com.mybatisDemo.pojo.QueryVo;
import com.mybatisDemo.pojo.User;

import java.util.List;

public interface UserMapper {
    public User selectById(Integer id);

    public List<User> selectByQueryVo(QueryVo vo);

    public Integer selectUserNumbers();

    public List<User> selectBySexAndName(User user);

    public List<User> selectUserByListIds(List<Integer> ids);
    public List<User> selectUserByArrayIds(Integer[] ids);
    public List<User> selectUserByIdsWithVo(QueryVo vo);

    //一对多关联查询
    public List<User> selectUserWithOrdersList(Integer id);
}
