package com;


import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DemoTest {
    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void demo(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo("王五");
        User user = new User();
        user.setAddress("shanghai");
        userMapper.updateByExampleSelective(user,userExample);
    }
}