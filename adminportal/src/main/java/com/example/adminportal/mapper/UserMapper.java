package com.example.adminportal.mapper;

import com.example.adminportal.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryById(@Param("id") long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User queryByUsername(@Param("username") String username);

    @Select("SELECT * FROM user WHERE username = #{username} and password = #{password}")
    User queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
