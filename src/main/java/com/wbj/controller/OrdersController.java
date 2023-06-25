package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.pojo.Orders;
import com.wbj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    /**
     * 查询用户中的订单
     * @param userId    用户id
     * @return          订单信息
     */
    @GetMapping("user")
    public R<ArrayList<Orders>> getUserOrders(int userId){
        return orderService.getUserOrders(userId);
    }
}
