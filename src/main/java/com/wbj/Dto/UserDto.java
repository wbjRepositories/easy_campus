package com.wbj.Dto;

import com.wbj.pojo.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends User {
    private String ClassName;
}
