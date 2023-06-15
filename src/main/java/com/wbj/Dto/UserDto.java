package com.wbj.Dto;

import com.wbj.pojo.User;
import lombok.Data;

@Data
public class UserDto extends User {
    //商户评分
    private double grade;
    //评分人数
    private Integer number;
}
