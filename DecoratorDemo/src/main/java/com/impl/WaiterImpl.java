package com.impl;

import com.interfaces.Waiter;

public class WaiterImpl implements Waiter {
    @Override
    public void service() {
        System.out.println("在服务...");
    }
}
