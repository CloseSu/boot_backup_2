package com.example.practice.mapper;

import com.example.practice.entity.UserPermission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPermissionMapper {

    @Select("select * from userpermision")
    @Results({
            @Result(property = "perId",  column = "perId", id=true),
            @Result(property = "permission", column = "permission")
    })
    List<UserPermission> getUserPermissionAll();

    @Select("select * from userpermision where perId = #{id}")
    @Results({
            @Result(property = "perId",  column = "perId", id=true),
            @Result(property = "permission", column = "permission")
    })
    UserPermission getUserPermissionById(Integer perId);

    @Insert("INSERT INTO userpermision(permission) " +
            "VALUES(#{permission})")
    @Options(useGeneratedKeys=true, keyProperty="perId")
    void insert(UserPermission userPermission);

    @Update("UPDATE userpermision SET " +
            "permission= #{permission}" +
            "WHERE perId = #{perId}")
    void update(UserPermission userPermission);

    @Delete("DELETE FROM userpermision WHERE perId =#{perId}")
    void deleteById(Integer perId);
}
