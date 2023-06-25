package com.wbj.mapper;

import com.wbj.pojo.Orders;

import java.util.ArrayList;

public interface OrderMapper {

    ArrayList<Orders> selectUserOrders(int userId);
}
