package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 按照分页获取商户信息
     * @param currentPage   当前页
     * @param pageSize      每页大小
     * @return
     */
    @GetMapping("businessmen")
    public R getBusinessmen(@RequestParam(required = false,defaultValue = "1") int currentPage
            ,@RequestParam(required = false,defaultValue = "8") int pageSize){
        return orderService.getBusinessmanByPage(currentPage, pageSize);
    }

    /**
     * 根据商户id按照分页方式获取菜品
     * @param businessmanId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("dish")
    public R getDish(int businessmanId,@RequestParam(required = false,defaultValue = "1") int currentPage
            ,@RequestParam(required = false,defaultValue = "8") int pageSize){
        return orderService.getDishByPage(businessmanId,currentPage,pageSize);
    }

    /**
     * 获取当前商户的菜品数量
     * @param businessmanId
     * @return
     */
    @GetMapping("dishCount/{businessmanId}")
    public R getDishCount(@PathVariable int businessmanId){
        return orderService.getDishCount(businessmanId);
    }
}
