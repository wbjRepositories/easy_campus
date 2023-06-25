package com.wbj.pojo;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * orders，订单表
 */
@Data
public class Orders {
    /**
     * 商户id
     */
    private Long businessmanid;
    /**
     * 主键
     */
    private Long id;
    /**
     * 订单号
     */
    private String number;
    /**
     * 下单时间
     */
    private OffsetDateTime orderTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 订单状态;1待派送，2已派送，3已完成
     */
    private Long state;
    /**
     * 下单用户id
     */
    private Long userId;

}