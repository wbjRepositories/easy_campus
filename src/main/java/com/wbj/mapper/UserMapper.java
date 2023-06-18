package com.wbj.mapper;


import com.wbj.pojo.Class;
import com.wbj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface UserMapper {
    //用户登录
    User selectOneByLoginInfo(@Param("username") String username, @Param("password") String password,@Param("role") int role);

    //更改用户的name,gender,classId,phone,address,birthday
    Integer updateUserInfo(User user);

    //查询所有班级
    @Select("select * from class")
    ArrayList<Class> selectAllClass();
}
