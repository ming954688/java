package com.springIocAnnocation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao的实现类
 */
//@Component(value = "userDao") //相当于<bean id="userDao" class = "com.springIocAnnocation.UserDaoImpl">
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {


    @Value("李四")
    private String name;

   /* @Value("李四")
    public void setName(String name) {
        this.name = name;
    }*/

    @Override
    public void save() {
        System.out.println("保存用户"+name);
    }
}
