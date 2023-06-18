package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.OrderMapper;
import com.wbj.pojo.Businessman;
import com.wbj.pojo.Dish;
import com.wbj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public R<ArrayList<Businessman>> getBusinessmanByPage(int currentPage, int pageSize) {
        log.info("分页查询商户，当前页码：{} 每页数：{}",currentPage,pageSize);
        if (currentPage<0||pageSize<0){
            return R.fail("数据格式有误！");
        }
        return R.success(orderMapper.selectBusinessmanByPage((currentPage-1)*pageSize,pageSize),"分页查询商户成功！");
    }

    @Override
    public R<ArrayList<Dish>> getDishByPage(int businessmanId,int currentPage, int pageSize) {
        log.info("分页查询菜品，商户id：{}  当前页码：{} 每页数：{}",businessmanId,currentPage,pageSize);
        if (currentPage<0||pageSize<0){
            return R.fail("数据格式有误！");
        }
        ArrayList<Dish> dishes = orderMapper.selectDishByPage(businessmanId, currentPage, pageSize);
        return R.success(dishes,"查询菜品成功！");
    }

    @Override
    public R<Integer> getDishCount(int businessmanId) {
        log.info("查询当前商户的菜品数，当前商户id：{}",businessmanId);
        return R.success(orderMapper.selectDishCount(businessmanId),"查询菜品数成功！");
    }

}
