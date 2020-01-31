package com.ListenerDemo.Demo1;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request销毁了....");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request创建了...");
    }
}
