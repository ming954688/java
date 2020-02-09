package com.springAop.annocationAop;

//目标类
public class OrderDao {
    public void save(){
        System.out.println("保存订单");
    }

    public String find(){
        //int i = 1/0;
        System.out.println("查询订单");
        return "查询返回的值";
    }

    public int update(){
        System.out.println("修改订单");
        return 111;
    }

    public String delete(){
        System.out.println("删除订单");
        return "托尔斯泰";
    }
}
