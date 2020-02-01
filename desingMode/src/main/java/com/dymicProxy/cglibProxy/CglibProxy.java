package com.dymicProxy.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理
 */
public class CglibProxy {
    private CustomerDao customerDao;

    public CglibProxy(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    //使用cglib产生代理的方法
    public CustomerDao createProxy() {
        //1. 创建cglib的核心类对象
        Enhancer enhancer = new Enhancer();
        // 2. 设置父类:
        enhancer.setSuperclass(customerDao.getClass());
        // 3. 设置回调(类似InvocationHandler)
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equalsIgnoreCase("save")) {
                    System.out.println("增强save方法");
                    return methodProxy.invokeSuper(proxy, args);
                }

                return methodProxy.invokeSuper(proxy, args);
            }
        });

        // 4. 创建代理对象
        CustomerDao proxy = (CustomerDao) enhancer.create();
        return proxy;
    }


}
