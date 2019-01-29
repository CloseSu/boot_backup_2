package com.example.practice.mapperTest;

import com.example.practice.entity.UserPermission;
import com.example.practice.mapper.UserPermissionMapper;
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
public class UserPermissionMapperTest {

    @Autowired
    private UserPermissionMapper userPermissionMapper;
    private static UserPermission userPermission = new UserPermission();

    @Test
    public void AtestQueryAll() {
        List<UserPermission> userPermissionList = userPermissionMapper.getUserPermissionAll();
        userPermissionList.forEach(list -> System.out.println(list));
    }

    @Test
    public void BtestQuery() {
        UserPermission userPermission = userPermissionMapper.getUserPermissionById(1);
        System.out.println(userPermission);
    }

    @Test
    public void CtestInsert() {
        userPermission.setPermission("test");
        userPermissionMapper.insert(userPermission);
        System.out.println(userPermission);
    }

    @Test
    public void DtestUpdate() {
        UserPermission userRoleUpdate = userPermissionMapper.getUserPermissionById(userPermission.getPerId());
        userRoleUpdate.setPermission("test2");
        userPermissionMapper.update(userRoleUpdate);
        UserPermission userRoleUpdated = userPermissionMapper.getUserPermissionById(userPermission.getPerId());
        System.out.println(userRoleUpdated);
    }

    @Test
    public void EtestDelete() {
        userPermissionMapper.deleteById(userPermission.getPerId());
        UserPermission userRoleDelete = userPermissionMapper.getUserPermissionById(userPermission.getPerId());
        System.out.println(userRoleDelete);
    }
}
