package com.wbj.mapper;


import com.wbj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //用户登录
    @Select("select id,num,username,name,gender,class_id,phone,address,birthday,create_time,state,is_job,businessman_id,role" +
            " from user where username = #{username} and password = #{password} and role = #{role}")
    User selectOneByLoginInfo(@Param("username") String username, @Param("password") String password,@Param("role") int role);
}
