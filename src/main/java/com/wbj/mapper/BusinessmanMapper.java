package com.wbj.mapper;

import com.wbj.pojo.Businessman;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface BusinessmanMapper {
    /**
     * 通过分页的方式查询商户
     * @param index 起始位置
     * @param offset 偏移量
     * @return
     */
    @Select("select id,name,avatar,username,phone,grade,number from businessman limit #{index},#{offset}")
    ArrayList<Businessman> selectBusinessmenByPage(@Param("index") int index, @Param("offset") int offset);
}
