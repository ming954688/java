package com.transaction;

import com.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "update account set money = money + ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //扣钱, id为1的扣了1000块钱
            ps.setInt(1, -1000);
            ps.setInt(2, 1);
            ps.executeUpdate();


            //加钱, id为2的加了1000块钱
            ps.setInt(1, 1000);
            ps.setInt(2, 2);
            ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        }

       /* ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name") + "==" + rs.getInt("money"));
        }*/
    }
}
