package com.wbj.mapper;


import com.wbj.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //用户登录
    User selectOneByLoginInfo(@Param("username") String username, @Param("password") String password,@Param("role") int role);


    //查询用户个人信息
    User selectOneUser(int userId);


    //更改用户的name,gender,classId,phone,address,birthday
    Integer updateUserInfo(User user);


}
