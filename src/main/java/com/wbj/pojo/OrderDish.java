package com.wbj.pojo;

import lombok.Data;

/**
 * order_dish，订单菜品关系表
 */
@Data
public class OrderDish {
    /**
     * 菜品id
     */
    private Long dishId;
    /**
     * id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;

}