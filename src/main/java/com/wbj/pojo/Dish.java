package com.wbj.pojo;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * dish，菜品表
 */
@Data
public class Dish {
    /**
     * 商户id
     */
    private String businessmanId;
    /**
     * 菜品id
     */
    private long id;
    /**
     * 图片
     */
    private String image;
    /**
     * 是否折扣;0：不折扣  1：折扣
     */
    private Long isPreferential;
    /**
     * 菜品名
     */
    private String name;
    /**
     * 价格
     */
    private double price;
    /**
     * 更新时间
     */
    private OffsetDateTime updateTime = OffsetDateTime.now();
    /**
     * 重量
     */
    private Double weight;
}