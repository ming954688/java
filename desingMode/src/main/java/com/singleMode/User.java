package com.singleMode;
/**
 * 单例模式:
 * 1. 私有化构造方法
 * 2. 封装一个私有的静态成员. 创建对象.
 * 3. 写一个静态的方法(getInstance) 返回这个对象.
 */
public class User {
    private User(){

    }

    private static User user = new User();

    public static User getInstance(){
        return user;
    }
}
