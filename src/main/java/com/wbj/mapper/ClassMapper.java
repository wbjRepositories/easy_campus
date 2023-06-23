package com.wbj.mapper;

import com.wbj.pojo.Class;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ClassMapper {
    //查询所有班级
    @Select("select * from class")
    ArrayList<Class> selectAllClass();
}
