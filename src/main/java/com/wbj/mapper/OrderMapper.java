package com.wbj.mapper;

import com.wbj.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface OrderMapper {
    /**
     * 查询用户订单
     * @param userId    用户id
     * @return          订单信息
     */
    ArrayList<Orders> selectUserOrders(int userId);

    /**
     * 插入订单
     * @param orders    订单信息
     */
    void insertOrder(Orders orders);

    /**
     * 插入订单菜品
     * @param orderId   订单id
     * @param dishIds   菜品id
     */
    void insertOrderDish(@Param("orderId") int orderId,@Param("dishIds") int ...dishIds);
}
