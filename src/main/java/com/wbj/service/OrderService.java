package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Orders;

import java.util.ArrayList;

public interface OrderService {
    R<ArrayList<Orders>> getUserOrders(int userId);
}
