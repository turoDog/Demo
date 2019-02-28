package com.nasus.mybatisxml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nasus.mybatisxml.mapper")
public class MybatisxmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisxmlApplication.class, args);
    }

}
