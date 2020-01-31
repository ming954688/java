package com.ListenerDemo.Demo3.HttpSessionActivationListener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MySessionActivationListener implements HttpSessionActivationListener {
    //序列化
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session被序列化了. ");
    }

    //反序列化
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("session被反序列化了. ");

    }
}
