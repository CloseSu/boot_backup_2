package com.example.practice.service;

import com.example.practice.entity.User;
import com.example.practice.entity.UserPermission;
import com.example.practice.entity.UserRole;
import com.example.practice.mapper.UserMapper;
import com.example.practice.mapper.UserPermissionMapper;
import com.example.practice.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UerService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserPermissionMapper userPermissionMapper;

    public User getUserAll(String username) {
        User user = userMapper.getUserByName(username);
        Set<String> roleSet = new HashSet<>();
        for(String roleId: user.getRoleIds().split(",")) {
            UserRole userRole = userRoleMapper.getUserRoleById(Integer.parseInt(roleId));
            roleSet.add(userRole.getRole());
        }
        Set<String> permissionSet = new HashSet<>();
        for (String perId: user.getPerIds().split(",")) {
            UserPermission userPermission = userPermissionMapper.getUserPermissionById(Integer.parseInt(perId));
            permissionSet.add(userPermission.getPermission());
        }
        user.setRoleSet(roleSet);
        user.setPermissionSet(permissionSet);

        return user;
    }
}
