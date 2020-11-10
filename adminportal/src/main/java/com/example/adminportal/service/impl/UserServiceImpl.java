package com.example.adminportal.service.impl;

import com.example.adminportal.mapper.UserMapper;
import com.example.adminportal.model.User;
import com.example.adminportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(long id) {
        return userMapper.queryById(id);
    }


}
