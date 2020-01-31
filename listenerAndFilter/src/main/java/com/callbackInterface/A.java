package com.callbackInterface;

import com.callbackInterface.interfaces.PrintListener;

public class A {
    public void print(PrintListener listener){
        for (int i = 0; i < 10; i++) {
            if(i == 5 ){
                listener.print();
            }
        }
    }
}
