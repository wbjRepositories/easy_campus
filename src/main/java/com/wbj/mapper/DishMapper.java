package com.wbj.mapper;

import com.wbj.pojo.Dish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface DishMapper {


    /**
     * 通过分页的方式查询菜品
     * @param businessmanId  商户id
     * @param index     起始位置
     * @param offset    偏移量
     * @return          分页菜品
     */

    ArrayList<Dish> selectDishByPage(@Param("businessmanId") int businessmanId,@Param("index") int index, @Param("offset") int offset);

    /**
     * 查询商户的菜品数量
     * @param businessmanId 商户id
     * @return              菜品数量
     */
    @Select("select count(*) from dish where businessman_id = #{businessmanId}")
    Integer selectDishCount(int businessmanId);

    /**
     * 根据菜品id删除当前商户的菜品
     * @param businessmanId 商户id
     * @param dishId        菜品id
     */
    @Delete("delete from dish where businessman_id = #{businessmanId} and id = #{dishId}")
    int deleteOne(@Param("businessmanId") int businessmanId,@Param("dishId") int dishId);

    /**
     * 批量删除菜品
     * @param businessmanId 商户id
     * @param ids           菜品id数组
     * @return              删除的行数
     */
    int deleteMultiple(@Param("businessmanId") int businessmanId,@Param("ids") int ...ids);

    /**
     * 更新当前商户下的某菜品信息
     * @param currentId 当前商户id
     * @param dish      菜品id
     * @return          修改行数
     */
    int updateDish(@Param("currentId") int currentId,@Param("dish") Dish dish);

    /**
     * 插入菜品，插入成功后把主键返回给dish对象
     * @param currentId 当前商户id
     * @param dish      菜品信息
     */
    void insertDish(@Param("currentId") int currentId,@Param("dish") Dish dish);
}
