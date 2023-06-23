package com.wbj;

import com.wbj.service.DishService;
import com.wbj.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class EasyCampusApplicationTests {
    @Autowired
    DishService service;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() throws IOException, InterruptedException {

    }

}
