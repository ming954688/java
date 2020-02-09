package com.springJdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_C3P0.xml")
/**
 * springJdbc模板的CRUD操作
 */
public class UserTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //保存用户
    @Test
    public void test() {
        int update = jdbcTemplate.update("insert into user values (null,?,?,?,?)", "xiaozhang", 23, "男", "342");
        System.out.println(update);
    }

    //更新用户
    @Test
    public void test1() {
        int myself = jdbcTemplate.update("update user set username = ? where id = ?", "myself", 1);
        System.out.println(myself);
    }

    //删除用户
    @Test
    public void test2() {
        int update = jdbcTemplate.update("delete from user where username = ? ", "xiaozhang");
        System.out.println(update);
    }

    /**
     * 查询操作
     */
    @Test
    public void demo() {
        String name = jdbcTemplate.queryForObject("select username from user where id = ?", String.class, 1);
        System.out.println(name);
    }

    //查询有多少条数据
    @Test
    public void demo1() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        System.out.println(aLong);
    }

    //查询单个记录 , 封装到对象中
    @Test
    public void demo2() {
        User user = jdbcTemplate.queryForObject("select * from user where id = ?",new MyUser(), 1);
        System.out.println(user);
    }

    //查询多个记录, 封装到list中
    @Test
    public void demo3(){
        List<User> list = jdbcTemplate.query("select * from user",new MyUser());
        for (User user : list) {
            System.out.println(user);
        }
    }


    class MyUser implements RowMapper<User>{

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            int age = rs.getInt("age");
            String sex = rs.getString("sex");
            String password = rs.getString("password");
            User user = new User(id, username, age, sex, password);
            return user;
        }
    }
}