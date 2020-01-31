package com.callbackInterface;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.print(new PrintListenerImpl());
    }
}
