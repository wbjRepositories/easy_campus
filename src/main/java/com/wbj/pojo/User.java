package com.wbj.pojo;

import lombok.Data;

import java.time.OffsetDateTime;

/**
 * user，用户表
 */
@Data
public class User {
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 出生日期
     */
    private OffsetDateTime birthday;
    /**
     * 商户id
     */
    private Long businessmanid;
    /**
     * 班级id
     */
    private String classid;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 性别
     */
    private long gender;
    /**
     * id
     */
    private long id;
    /**
     * 是否兼职;0：未有兼职  1：已有兼职
     */
    private long isJob;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String num;
    /**
     * 学生：num  老师：phone
     */
    private String username;
    /**
     * 密码;默认是学号后六位
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 角色;1：学生  2：老师
     */
    private Long role;
    /**
     * 状态;0：在校  1：事假  2：病假  3：正在审批
     */
    private long state;
}