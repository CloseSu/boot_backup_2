package com.example.practice.mapperTest;

import com.example.practice.entity.User;
import com.example.practice.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryAll() {
        List<User> users = userMapper.getUserAll();
        users.forEach(user -> System.out.println(user.getUsername()));
    }

    @Test
    public void testQuery() {
        User user = userMapper.getUserById(0);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("111");
        user.setRoleIds("1");
        user.setPerIds("0");
        userMapper.insert(user);
        System.out.println(user.getUserId());
    }

    @Test
    public void testUpdate() {
        User user = userMapper.getUserById(8);
        System.out.println(user.getUsername());
        user.setUsername("idiot");
        userMapper.update(user);
        user = userMapper.getUserById(8);
        System.out.println(user.getUsername());
    }

    @Test
    public void testDelete() {
        User user = userMapper.getUserById(8);
        userMapper.deleteById(8);
        user = userMapper.getUserById(8);
        System.out.println(user);
    }
}
