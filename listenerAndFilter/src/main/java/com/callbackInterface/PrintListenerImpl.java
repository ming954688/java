package com.callbackInterface;

import com.callbackInterface.interfaces.PrintListener;

public class PrintListenerImpl implements PrintListener {
    public void print() {
        System.out.println("我是PrintListener的实现类, 现在A已经循环到5了...");
    }
}
