package com.utils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 1. 这是一个数据库连接池, 一开始往里面放十个连接
 * 2. 来的程序使用getConnection获取连接
 * 3. 用完之后, 归还连接
 * 4. 扩容
 *
 * 缺点, 不能面向接口编程
 * 由于多了一个addBack()方法,需要用到这个连接池的地方需要额外记住一个addBack方法.
 * 解决: 打算修改接口中的close()方法
 * 原有的方法逻辑, 不是我们想要的, 想修改为自己的逻辑
 *      1. 直接修改源码
 *      2. 使用继承, 重写close()方法
 *      3. 使用装饰者模式
 *      4. 动态代理
 */
public class MyDataSource implements DataSource {

    static List<Connection> list = new ArrayList<Connection>();


    static{
        for (int i = 0; i < 10; i++) {
            Connection conn = JDBCUtil.getConn();
            list.add(conn);
        }

    }

    //对外暴露的获取连接的方法
    @Override
    public Connection getConnection() throws SQLException {
        //看看池子中有没有连接了. 如果没有了, 创建.
        if(list.size() == 0){
            for (int i = 0; i < 10; i++) {
                Connection conn = JDBCUtil.getConn();
                list.add(conn);
            }
        }
        Connection conn = new ConnectionWrap(list.remove(0),list);
        return conn;
    }

    //使用完了之后, 归还.
    public void addBack(Connection connection){
        list.add(connection);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
