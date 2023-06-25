package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.OrderMapper;
import com.wbj.pojo.Orders;
import com.wbj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public R<ArrayList<Orders>> getUserOrders(int userId) {
        log.info("查询用户订单，用户id：{}",userId);
        return R.success(orderMapper.selectUserOrders(userId),"查询用户订单成功！");
    }
}
