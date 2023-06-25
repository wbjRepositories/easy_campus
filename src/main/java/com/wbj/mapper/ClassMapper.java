package com.wbj.mapper;

import com.wbj.pojo.Class;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ClassMapper {
    //查询所有班级
    @Select("select * from class")
    ArrayList<Class> selectAllClass();
    //添加班级
    @Insert("insert into class(name,class_num) values(#{name},#{classNum})")
    void insertClass(Class c);
    //修改班级
    int updateClass(Class c);
    //删除班级
    int deleteClassByIds(@Param("ids") int ...ids);
}
