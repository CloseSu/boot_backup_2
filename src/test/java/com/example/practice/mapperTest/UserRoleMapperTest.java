package com.example.practice.mapperTest;

import com.example.practice.entity.UserRole;
import com.example.practice.mapper.UserRoleMapper;
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
public class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper userRoleMapper;
    private static UserRole userRole = new UserRole();

    @Test
    public void AtestQueryAll() {
        List<UserRole> userRoleList = userRoleMapper.getUserRoleAll();
        userRoleList.forEach(role -> System.out.println(role));
    }

    @Test
    public void BtestQuery() {
        UserRole userRole = userRoleMapper.getUserRoleById(0);
        System.out.println(userRole);
    }

    @Test
    public void CtestInsert() {
        userRole.setRole("test");
        userRoleMapper.insert(userRole);
        System.out.println(userRole);
    }

    @Test
    public void DtestUpdate() {
        UserRole userRoleUpdate = userRoleMapper.getUserRoleById(userRole.getRoleId());
        userRoleUpdate.setRole("test2");
        userRoleMapper.update(userRoleUpdate);
        UserRole userRoleUpdated = userRoleMapper.getUserRoleById(userRole.getRoleId());
        System.out.println(userRoleUpdated);
    }

    @Test
    public void EtestDelete() {
        userRoleMapper.deleteById(userRole.getRoleId());
        UserRole userRoleDelete = userRoleMapper.getUserRoleById(userRole.getRoleId());
        System.out.println(userRoleDelete);
    }
}
