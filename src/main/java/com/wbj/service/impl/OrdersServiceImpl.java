package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.OrderMapper;
import com.wbj.pojo.Orders;
import com.wbj.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public R<ArrayList<Orders>> getUserOrders(int userId) {
        log.info("查询用户订单，用户id：{}", userId);
        return R.success(orderMapper.selectUserOrders(userId), "查询用户订单成功！");
    }

    /**
     * 用户下单
     * @param orders    订单信息
     * @param dishIds   菜品id
     * @return          成功或失败信息
     */
    @Override
    public R addOrder(Orders orders, int... dishIds) {
        log.info("用户下单，商户id：{}  用户id：{}  备注：{}  收货地址id：{}  菜品id:{}",
                orders.getBusinessmanId(), orders.getUserId(), orders.getRemark(), orders.getShippingAddressId(), dishIds);
        if (orders.getBusinessmanId() == null || orders.getUserId() == null || orders.getShippingAddressId() == null) {
            return R.fail("数据不能为空！");
        }
        if (dishIds.length < 1) {
            return R.fail("没有选择菜品不可下单！");
        }
        //生成订单号
        String number = UUID.randomUUID().toString();
        orders.setNumber(number);

        //插入订单
        orderMapper.insertOrder(orders);

        //插入订单菜品
        orderMapper.insertOrderDish(orders.getId(), dishIds);
        return R.success("用户下单成功！");
    }
}
