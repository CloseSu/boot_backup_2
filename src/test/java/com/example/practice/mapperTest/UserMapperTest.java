package com.example.practice.mapperTest;

import com.example.practice.entity.User;
import com.example.practice.mapper.UserMapper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    private static User testUser = new User();

    @Test
    public void AtestQueryAll() {
        List<User> users = userMapper.getUserAll();
        users.forEach(user -> System.out.println(user.getUsername()));
    }

    @Test
    public void BtestQuery() {
        User user = userMapper.getUserById(0);
        System.out.println(user);
    }

    @Test
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
    public void EtestDelete() {
        System.out.println("testDelete====================");
        userMapper.deleteById(testUser.getUserId());
        User user = userMapper.getUserById(testUser.getUserId());
        System.out.println(user);
    }
}
