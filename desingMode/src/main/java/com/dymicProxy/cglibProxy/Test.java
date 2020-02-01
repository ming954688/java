package com.dymicProxy.cglibProxy;

public class Test {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        CglibProxy cglibProxy = new CglibProxy(customerDao);
        CustomerDao proxy = cglibProxy.createProxy();
        proxy.save();

    }
}
