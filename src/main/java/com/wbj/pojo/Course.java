package com.wbj.pojo;

import lombok.Data;

/**
 * course，课程
 */
@Data
public class Course {
    /**
     * 班级id
     */
    private Long classid;
    /**
     * 课程节次;只能填1~8的数字
     */
    private Long classPeriod;
    /**
     * 教室id
     */
    private Long classroomid;
    /**
     * 课程id
     */
    private long id;
    /**
     * 课程名字
     */
    private String name;
    /**
     * 星期;只能填1~7的数字
     */
    private Long week;
}