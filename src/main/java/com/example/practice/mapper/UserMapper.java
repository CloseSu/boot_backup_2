package com.example.practice.mapper;

import com.example.practice.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from user")
    @Results({
            @Result(property = "userId",  column = "userid", id=true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "roleIds", column = "roleids"),
            @Result(property = "perIds", column = "perids")
    })
    List<User> getUserAll();

    @Select("select * from user where userid = #{id}")
    @Results({
            @Result(property = "userId",  column = "userid", id=true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "roleIds", column = "roleids"),
            @Result(property = "perIds", column = "perids")
    })
    User getUserById(Integer userId);

    @Select("select * from user where username = #{username}")
    @Results({
            @Result(property = "userId",  column = "userid", id=true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "roleIds", column = "roleids"),
            @Result(property = "perIds", column = "perids")
    })
    User getUserByName(String username);


    @Insert("INSERT INTO user(username,password,roleIds,perIds) " +
            "VALUES(#{username}, #{password}, #{roleIds}, #{perIds})")
    @Options(useGeneratedKeys=true, keyProperty="userId")
    void insert(User user);

    @Update("UPDATE user SET " +
            "username=#{username}," +
            "password=#{password}," +
            "roleIds=#{roleIds}, " +
            "perIds=#{perIds} " +
            "WHERE userId =#{userId}")
    void update(User user);

    @Delete("DELETE FROM user WHERE userId =#{id}")
    void deleteById(Integer id);

}
