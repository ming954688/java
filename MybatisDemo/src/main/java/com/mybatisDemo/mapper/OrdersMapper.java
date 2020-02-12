package com.mybatisDemo.mapper;

import com.mybatisDemo.pojo.Orders;

import java.util.List;

public interface OrdersMapper {
    public List<Orders> selectAllOrders();

    //一对一关联查询 以订单为中心, 关联用户
    public List<Orders> selectOrders();
}
