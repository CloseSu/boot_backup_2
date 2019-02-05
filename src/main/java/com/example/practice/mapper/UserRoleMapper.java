package com.example.practice.mapper;

import com.example.practice.entity.UserRole;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {

    @Select("select * from userrole")
    @Results({
            @Result(property = "roleId", column = "roleId", id = true),
            @Result(property = "role", column = "role")
    })
    List<UserRole> getUserRoleAll();

    @Select("select * from userrole where roleId = #{id}")
    @Results({
            @Result(property = "roleId", column = "roleId", id = true),
            @Result(property = "role", column = "role")
    })
    UserRole getUserRoleById(Integer roleId);

    @Insert("INSERT INTO userrole(role) " +
            "VALUES(#{role})")
    @Options(useGeneratedKeys = true, keyProperty = "roleId")
    void insert(UserRole userRole);

    @Update("UPDATE userrole SET " +
            "role= #{role}" +
            "WHERE roleId = #{roleId}")
    void update(UserRole userRole);

    @Delete("DELETE FROM userrole WHERE roleId =#{roleId}")
    void deleteById(Integer roleId);
}
