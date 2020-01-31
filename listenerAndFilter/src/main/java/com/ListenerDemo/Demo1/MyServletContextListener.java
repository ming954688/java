package com.ListenerDemo.Demo1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    //初始化的时候调用
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletContext初始化了.....");
    }

    //销毁时调用
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContext销毁了.....");
    }
}
