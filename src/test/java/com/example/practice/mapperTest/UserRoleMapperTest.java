package com.example.practice.mapperTest;

import com.example.practice.entity.UserRole;
import com.example.practice.mapper.UserRoleMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;
    private static UserRole userRole = new UserRole();

    @Test
    @Order(1)
    public void testQueryAll() {
        System.out.println("================1======================");
        List<UserRole> userRoleList = userRoleMapper.getUserRoleAll();
        userRoleList.forEach(role -> System.out.println(role));
    }

    @Test
    @Order(2)
    public void testQuery() {
        System.out.println("================2======================");
        UserRole userRole = userRoleMapper.getUserRoleById(0);
        System.out.println(userRole);
    }

    @Test
    @Order(3)
    public void testInsert() {
        System.out.println("================3======================");
        userRole.setRole("test");
        userRoleMapper.insert(userRole);
        System.out.println(userRole);
    }

    @Test
    @Order(4)
    public void DtestUpdate() {
        System.out.println("================4======================");
        UserRole userRoleUpdate = userRoleMapper.getUserRoleById(userRole.getRoleId());
        userRoleUpdate.setRole("test2");
        userRoleMapper.update(userRoleUpdate);
        UserRole userRoleUpdated = userRoleMapper.getUserRoleById(userRole.getRoleId());
        System.out.println(userRoleUpdated);
    }

    @Test
    @Order(5)
    public void EtestDelete() {
        System.out.println("================5======================");
        userRoleMapper.deleteById(userRole.getRoleId());
        UserRole userRoleDelete = userRoleMapper.getUserRoleById(userRole.getRoleId());
        System.out.println(userRoleDelete);
    }
}
