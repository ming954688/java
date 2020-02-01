package com.dymicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDaoProxy implements InvocationHandler {
    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao createProxy() {
        UserDao userdaoProxy = (UserDao) Proxy.newProxyInstance(UserDaoProxy.class.getClassLoader(), userDao.getClass().getInterfaces(), this);
        return userdaoProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        if (method.getName().equalsIgnoreCase("add")) {
            System.out.println("增强add方法");
            method.invoke(userDao, args);
            return object;
        }
        object = method.invoke(userDao, args);
        return object;
    }
}
