package com.mybatisDemo;

import com.mybatisDemo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Demo1Test {
    private SqlSession sqlSession = null;


    @Before
    public void beforeTest() throws IOException {

        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //创建sqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * @param
     * @return void
     * @描述: 通过id查询单个用户
     * @author Ming
     * @date 2020/2/11 16:37
     */
    @Test
    public void test() throws IOException {

        User user = sqlSession.selectOne("User.selectById", 10);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * @param
     * @return void
     * @描述: 通过名字进行模糊查询
     * @author Ming
     * @date 2020/2/11 16:57
     */
    @Test
    public void test1() throws IOException {
        List<User> users = sqlSession.selectList("selectByUserName", "王");
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * @param
     * @return void
     * @描述: 添加用户
     * @author Ming
     * @date 2020/2/11 17:00
     */
    @Test
    public void test2() throws ParseException {
        User user = new User();
        user.setUsername("ming");
        user.setSex("男");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1995, 03, 06);
        Date date = calendar.getTime();
        user.setBirthday(date);
        user.setAddress("合肥");
        int addUser = sqlSession.insert("addUser", user);
        sqlSession.commit();
        System.out.println(addUser);
    }

    /**
     * @param
     * @return void
     * @描述: 添加用户返回ID
     * @author Ming
     * @date 2020/2/11 17:45
     */
    @Test
    public void test3() {
        User user = new User();
        user.setUsername("tong");
        user.setSex("男");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1995, 03, 06);
        Date date = calendar.getTime();
        user.setBirthday(date);
        user.setAddress("合肥");
        int addUser = sqlSession.insert("addUserReturnId", user);
        System.out.println(user.getId());
        sqlSession.commit();
    }

    /**
     * @param
     * @return void
     * @描述: 更新用户
     * @author Ming
     * @date 2020/2/11 18:03
     */
    @Test
    public void test4() {
        User user = new User();
        user.setId(31);
        user.setUsername("sheng");
        user.setSex("男");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, 07, 06);
        Date date = calendar.getTime();
        user.setBirthday(date);
        user.setAddress("biejing");
        sqlSession.update("updateUser", user);
        sqlSession.commit();
    }

    @Test
    public void test5() {
        sqlSession.delete("deleteUserById", 31);
        sqlSession.commit();
    }



    @After
    public void afterTest() {
        sqlSession.close();
    }


}