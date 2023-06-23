package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.DishMapper;
import com.wbj.pojo.Dish;
import com.wbj.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;


    @Override
    public R<ArrayList<Dish>> getDishByPage(int businessmanId,int currentPage, int pageSize) {
        log.info("分页查询菜品，商户id：{}  当前页码：{} 每页数：{}",businessmanId,currentPage,pageSize);
        if (currentPage<0||pageSize<0){
            return R.fail("数据格式有误！");
        }
        ArrayList<Dish> dishes = dishMapper.selectDishByPage(businessmanId, currentPage, pageSize);
        return R.success(dishes,"查询菜品成功！");
    }

    @Override
    public R<Integer> getDishCount(int businessmanId) {
        log.info("查询当前商户的菜品数，当前商户id：{}",businessmanId);
        return R.success(dishMapper.selectDishCount(businessmanId),"查询菜品数成功！");
    }

    @Override
    public R removeDish(int businessmanId, int dishId) {
        int flag = dishMapper.deleteOne(businessmanId, dishId);
        if (flag >= 1){
            log.info("删除菜品，当前商户id：{}  菜品id：{}",businessmanId,dishId);
            return R.success("删除菜品成功");
        }else {
            log.warn("删除菜品失败，没有这个菜品！检查商户id和菜品id是否正确！");
            return R.fail("没有这个菜品！");
        }

    }

}
