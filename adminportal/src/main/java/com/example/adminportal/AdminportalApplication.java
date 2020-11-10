package com.example.adminportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.adminportal.mapper")
public class AdminportalApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminportalApplication.class, args);

    }

}
