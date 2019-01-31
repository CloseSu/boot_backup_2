package com.example.practice.mapperTest;

import com.example.practice.entity.UserPermission;
import com.example.practice.mapper.UserPermissionMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserPermissionMapperTest {

    @Autowired
    private UserPermissionMapper userPermissionMapper;
    private static UserPermission userPermission = new UserPermission();

    @Test
    @Order(1)
    public void testQueryAll() {
        List<UserPermission> userPermissionList = userPermissionMapper.getUserPermissionAll();
        userPermissionList.forEach(list -> System.out.println(list));
    }

    @Test
    @Order(2)
    public void testQuery() {
        UserPermission userPermission = userPermissionMapper.getUserPermissionById(1);
        System.out.println(userPermission);
    }

    @Test
    @Order(3)
    public void testInsert() {
        userPermission.setPermission("test");
        userPermissionMapper.insert(userPermission);
        System.out.println(userPermission);
    }

    @Test
    @Order(4)
    public void testUpdate() {
        UserPermission userRoleUpdate = userPermissionMapper.getUserPermissionById(userPermission.getPerId());
        userRoleUpdate.setPermission("test2");
        userPermissionMapper.update(userRoleUpdate);
        UserPermission userRoleUpdated = userPermissionMapper.getUserPermissionById(userPermission.getPerId());
        System.out.println(userRoleUpdated);
    }

    @Test
    @Order(5)
    public void testDelete() {
        userPermissionMapper.deleteById(userPermission.getPerId());
        UserPermission userRoleDelete = userPermissionMapper.getUserPermissionById(userPermission.getPerId());
        System.out.println(userRoleDelete);
    }
}
