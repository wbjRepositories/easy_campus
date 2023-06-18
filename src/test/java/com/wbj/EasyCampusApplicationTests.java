package com.wbj;

import com.wbj.mapper.OrderMapper;
import com.wbj.pojo.Dish;
import com.wbj.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class EasyCampusApplicationTests {
    @Autowired
    OrderMapper mapper;
    OrderService service;

    @Test
    void contextLoads() {
        ArrayList<Dish> dishes = mapper.selectDishByPage(1, 1, 2);
        System.out.println(dishes);
    }

}
