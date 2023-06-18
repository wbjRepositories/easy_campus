package com.wbj.mapper;

import com.wbj.pojo.Businessman;
import com.wbj.pojo.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface OrderMapper {
    /**
     * 通过分页的方式查询商户
     * @param index 起始位置
     * @param offset 偏移量
     * @return
     */
    ArrayList<Businessman> selectBusinessmanByPage(@Param("index") int index,@Param("offset") int offset);

    /**
     * 通过分页的方式查询菜品
     * @param businessmanId  商户id
     * @param index     起始位置
     * @param offset    偏移量
     * @return
     */
    ArrayList<Dish> selectDishByPage(@Param("businessmanId") int businessmanId,@Param("index") int index, @Param("offset") int offset);
}
