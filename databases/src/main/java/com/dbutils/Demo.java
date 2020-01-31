package com.dbutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class Demo {
    static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mysql");
    static QueryRunner queryRunner = new QueryRunner(comboPooledDataSource);


    //增加
    public static void insertDemo() {
        //dbutils只是简化了CRUD代码, 但是连接的创建和获取, 不支持
        try {
            queryRunner.update("insert into account values (?,?,?)",5,"aa",1000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //删除
    public static void deleteDemo(){
        try {
            queryRunner.update("delete from account where id = ?",2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //修改
    public static void updateDemo(){
        try {
            queryRunner.update("update account set money = 100 where id = ?" , 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insertDemo();
        deleteDemo();
        updateDemo();
    }
}
