package com.wbj.mapper;


import com.wbj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //用户登录
    @Select("select * from user where username = #{username} and password = #{password} and role = #{role}")
    User selectOneByLoginInfo(@Param("username") String username, @Param("password") String password,@Param("role") int role);
}
