package com.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException {
        //String url = Demo.class.getClassLoader().getResource("c3p0-config.xml").toString();
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("mysql");
        Connection connection = comboPooledDataSource.getConnection();
        String sql = "select * from account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name") + "==" + resultSet.getInt("money"));
        }


    }
}
