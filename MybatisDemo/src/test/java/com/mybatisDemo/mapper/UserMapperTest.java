package com.mybatisDemo.mapper;

import com.mybatisDemo.pojo.QueryVo;
import com.mybatisDemo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import sun.security.util.math.intpoly.IntegerPolynomial;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    SqlSessionFactory factory = null;

    @Before
    public void beforeTest() throws IOException {

        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //创建sqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        factory = sqlSessionFactoryBuilder.build(resourceAsStream);
    }

    @Test
    public void demo() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
    }

    /**
     * @param
     * @return void
     * @描述: 使用pojo包装类查询
     * @author Ming
     * @date 2020/2/12 18:15
     */
    @Test
    public void demo1() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("王五");
        queryVo.setUser(user);
        List<User> users = mapper.selectByQueryVo(queryVo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }


    @Test
    public void demo2() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer integer = mapper.selectUserNumbers();
        System.out.println(integer);
    }

    @Test
    public void demo3() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User();
        //user1.setSex("1");
        user1.setUsername("王五");
        List<User> users = mapper.selectBySexAndName(user1);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void demo4() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(24);
        integers.add(2);
        integers.add(10);
        QueryVo queryVo = new QueryVo();

        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        queryVo.setIds(new Integer[]{1, 2, 24, 30});
        queryVo.setIdsList(integers);

        List<User> users = mapper.selectUserByIdsWithVo(queryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void demo5() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer[] arr = {1, 3, 10, 24};

        List<User> users = mapper.selectUserByArrayIds(arr);
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void demo6() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(10);
        integers.add(24);

        List<User> users = mapper.selectUserByListIds(integers);
        for (User user : users) {
            System.out.println(user);

        }
    }
    
    @Test
    public void demo7(){
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectUserWithOrdersList(1);
        for (User user : users) {
            System.out.println(user);
        }
    }

}