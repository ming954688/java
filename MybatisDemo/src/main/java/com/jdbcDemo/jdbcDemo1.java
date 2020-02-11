package com.jdbcDemo;

import java.sql.*;

/**
 * 描述: 原生jdbc连接数据库
 * Author: Ming
 * Date: 2020/2/11 2:10
 * version: 1.0
 */
public class jdbcDemo1 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://47.110.143.25:3306/mybatis?characterEncoding=utf-8","root","root");
            String sql = "select * from user where username = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"王五");
            rs = ps.executeQuery();

            while (rs.next()){
                String id = rs.getString("id");
                String username = rs.getString("username");
                System.out.println(id+"==="+username);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
