package com.springDemo2;

public class CustomerDaoImpl implements CustomerDao {
    public void init() {
        System.out.println("初始化....");
    }

    public void destory() {
        System.out.println("销毁..");
    }

    @Override
    public void save() {
        System.out.println("cuntomerDao的save方法执行了.");
    }
}
