package com.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mysql");
    static QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);

    //查询, 单个元素
    public static User query1() throws SQLException {
        User user = queryRunner.query("select * from account where id = ?", new ResultSetHandler<User>() {
            @Override
            public User handle(ResultSet resultSet) throws SQLException {
                User user1 = new User();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int money = resultSet.getInt("money");
                    user1.setName(name);
                    user1.setId(id);
                    user1.setMoney(money);
                }
                return user1;
            }
        }, 1);
        return user;
    }

    //查询单个元素,使用beanhandler
    public static User query2() throws SQLException {

        User user = queryRunner.query("select * from account where id = ? ", new BeanHandler<User>(User.class), 2);
        return user;
    }


    //查询多个对象
    public static List<User> query3() throws SQLException {
        List<User> users = queryRunner.query("select * from account", new BeanListHandler<User>(User.class));
        return users;
    }


    public static void main(String[] args) throws SQLException {
        /*User user = query1();
        User user = query2();
        System.out.println(user);*/

        ArrayList<User> users = (ArrayList<User>) query3();
        for (User user : users) {
            System.out.println(user);
        }


    }
}
