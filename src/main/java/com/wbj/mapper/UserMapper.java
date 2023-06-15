package com.wbj.mapper;


import com.wbj.pojo.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //用户登录
    @Select("select * from user where username = ${username} and password =${password}")
    User selectOneByLoginInfo(String username,String password);
}
