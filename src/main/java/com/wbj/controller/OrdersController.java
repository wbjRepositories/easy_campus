package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.pojo.Orders;
import com.wbj.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 查询用户中的订单
     * @param userId    用户id
     * @return          订单信息
     */
    @GetMapping("user")
    public R<ArrayList<Orders>> getUserOrders(int userId){
        return ordersService.getUserOrders(userId);
    }


    /**
     * 用户下单
     * @param orders    订单信息
     * @param dishIds   菜品id
     * @return          成功或失败信息
     */
    @PostMapping
    public R addOrder(@RequestBody Orders orders,int ...dishIds) {
        return ordersService.addOrder(orders,dishIds);
    }

}
