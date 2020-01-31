package com.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        //System.out.println(Demo1.class.getClassLoader().getResource("test/dbcp.properties"));
        //properties.load(Demo1.class.getClassLoader().getResourceAsStream("dbcp.properties"));
        FileInputStream fileInputStream = new FileInputStream("databases/src/main/resources/dbcp.properties");
        properties.load(fileInputStream);
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "select * from account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + "==" + resultSet.getInt("money"));
        }


    }
}
