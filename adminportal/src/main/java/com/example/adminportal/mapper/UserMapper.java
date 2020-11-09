package com.example.adminportal.mapper;

import com.example.adminportal.model.Book;
import com.example.adminportal.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User queryById(@Param("id") long id);

}
