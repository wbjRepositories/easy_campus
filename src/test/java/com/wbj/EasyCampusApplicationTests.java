package com.wbj;

import com.wbj.mapper.OrderMapper;
import com.wbj.pojo.Dish;
import com.wbj.pojo.User;
import com.wbj.service.OrderService;
import com.wbj.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class EasyCampusApplicationTests {
    @Autowired
    OrderMapper mapper;
    OrderService service;

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
//        User user = new User();
//        user.setName("aaa");
//        user.setId(11);
//        user.setClassId(222);
//        user.setNum("222");
//        user.setGender(222);
//        user.setAddress("2222");
//        user.setBirthday(OffsetDateTime.now());
//        user.setCreateTime("1999-10-10 00:00:00");
        System.out.println(userService.getAllClass());
    }

}
