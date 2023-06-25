package com.wbj.Dto;

import com.wbj.pojo.Orders;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrdersDto extends Orders {
    private String name;
}
