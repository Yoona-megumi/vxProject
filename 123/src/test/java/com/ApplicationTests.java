package com;

import com.mapper.UserMapper;
import com.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {


    }



}
