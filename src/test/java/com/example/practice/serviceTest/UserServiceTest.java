package com.example.practice.serviceTest;

import com.example.practice.entity.User;
import com.example.practice.mapper.UserMapper;
import com.example.practice.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSelect() {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("test1");
        user1.setPassword("000");
        User user2 = new User();
        user2.setUsername("test2");
        user2.setPassword("111");
        userList.add(user1);
        userList.add(user2);
        when(userMapper.getUserAll()).thenReturn(userList);
        System.out.println(userService.getUserAll());
    }
}
