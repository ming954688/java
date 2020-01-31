package com.ListenerDemo.Demo3.httpSessionBindingListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean implements HttpSessionBindingListener {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("值被绑定进来了...");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("值被解除绑定了...");

    }
}
