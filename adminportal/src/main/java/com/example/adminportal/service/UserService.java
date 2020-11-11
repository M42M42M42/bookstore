package com.example.adminportal.service;

import com.example.adminportal.model.User;

public interface UserService {

    User queryById(long id);

    User queryByUsername(String username);

    int login(String username, String password);

}
