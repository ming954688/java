package com.dymicProxy.jdkProxy;

public class Test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        UserDao proxy = userDaoProxy.createProxy();
        proxy.add();
        proxy.change();
        proxy.find();
        proxy.delete();
    }
}
