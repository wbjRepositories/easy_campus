package com.wbj.pojo;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * orders，订单表
 */
@Data
public class Orders {
    /**
     * 地址
     */
    private String address;
    /**
     * 商户id
     */
    private long businessmanid;
    /**
     * 菜品id
     */
    private String dishid;
    /**
     * 主键
     */
    private long id;
    /**
     * 订单号
     */
    private String number;
    /**
     * 下单时间
     */
    private OffsetDateTime orderTime;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 备注
     */
    private String remark;
    /**
     * 订单状态;1待派送，2已派送，3已完成
     */
    private long status;
    /**
     * 下单用户id
     */
    private long userid;

}