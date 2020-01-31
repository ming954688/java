package com.singleMode;

public class Test {
    public static void main(String[] args) {
        User user = User.getInstance();
        User user1 = User.getInstance();
        System.out.println(user == user1);
    }
}
