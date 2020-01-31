package com;

import com.interfaces.Waiter;

public class WaitDecorator implements Waiter {
    Waiter waiter = null;

    public WaitDecorator(Waiter waiter){
        this.waiter = waiter;
    }
    @Override
    public void service() {
        System.out.println("微笑....");
        waiter.service();
    }
}
