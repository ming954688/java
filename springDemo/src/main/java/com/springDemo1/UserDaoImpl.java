package com.springDemo1;

public class UserDaoImpl implements UserDao {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("这是userdaoImpl正在执行...."+name);
    }
}
