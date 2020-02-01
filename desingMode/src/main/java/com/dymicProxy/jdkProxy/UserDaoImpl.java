package com.dymicProxy.jdkProxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("新增用户...");
    }

    @Override
    public void change() {
        System.out.println("修改用户.....");
    }

    @Override
    public void find() {
        System.out.println("查询用户....");
    }

    @Override
    public void delete() {
        System.out.println("删除用户....");
    }
}
