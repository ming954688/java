package com.ListenerDemo.Demo3.HttpSessionActivationListener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class Person implements HttpSessionActivationListener, Serializable {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session被序列化了....");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("session被反序列化了....");

    }
}
