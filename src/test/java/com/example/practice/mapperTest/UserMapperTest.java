package com.example.practice.mapperTest;

import com.example.practice.entity.User;
import com.example.practice.mapper.UserMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    private static User testUser = new User();

    @Test
    @Order(1)
    public void AtestQueryAll() {
        List<User> users = userMapper.getUserAll();
        users.forEach(user -> System.out.println(user.getUsername()));
    }

    @Test
    @Order(2)
    public void BtestQuery() {
        User user = userMapper.getUserById(0);
        System.out.println(user);
        User user2 = userMapper.getUserByName("guest");
        System.out.println(user2);
    }

    @Test
    @Order(3)
    public void CtestInsert() {
        System.out.println("testInsert====================");
        testUser.setUsername("test");
        testUser.setPassword("111");
        testUser.setRoleIds("1");
        testUser.setPerIds("0");
        userMapper.insert(testUser);
        System.out.println("insert testUser" + testUser);
    }

    @Test
    @Order(4)
    public void DtestUpdate() {
        System.out.println("testUpdate====================");
        User user = userMapper.getUserById(testUser.getUserId());
        System.out.println(user.getUsername());
        user.setUsername("idiot");
        userMapper.update(user);
        user = userMapper.getUserById(testUser.getUserId());
        System.out.println(user.getUsername());
    }

    @Test
    @Order(5)
    public void EtestDelete() {
        System.out.println("testDelete====================");
        userMapper.deleteById(testUser.getUserId());
        User user = userMapper.getUserById(testUser.getUserId());
        System.out.println(user);
    }
}
