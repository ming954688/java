package com.springIocAnnocation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    //注入DAO
    @Autowired
    @Qualifier(value = "userDao")
    private UserDao dao;

    @Override
    public void save() {
        System.out.println("userService执行....");
        dao.save();
    }
}
