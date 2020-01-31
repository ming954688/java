package com.connectionPool;

import com.utils.JDBCUtil;
import com.utils.MyDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        MyDataSource dataSource = new MyDataSource();
        Connection connection = dataSource.getConnection();

        String sql = "select * from account";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("id")+"="+rs.getString("name")+"="+rs.getInt("money"));
        }

        JDBCUtil.release(connection,preparedStatement);

    }
}
