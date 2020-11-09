package com.example.adminportal.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String email;
    private boolean enabled;
    private String first_name;
    private String last_name;
    private String password;
    private String phone;
    private String username;
}
