package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;



    /**
     * 根据商户id按照分页方式获取菜品
     * @param businessmanId 商户id
     * @param currentPage   当前页
     * @param pageSize      每页大小
     * @return
     */
    @GetMapping("page")
    public R getDish(int businessmanId,@RequestParam(required = false,defaultValue = "1") int currentPage
            ,@RequestParam(required = false,defaultValue = "8") int pageSize){
        return dishService.getDishByPage(businessmanId,currentPage,pageSize);
    }

    /**
     * 获取当前商户的菜品数量
     * @param businessmanId 商户id
     * @return              菜品数量
     */
    @GetMapping("/count/{businessmanId}")
    public R getDishCount(@PathVariable int businessmanId){
        return dishService.getDishCount(businessmanId);
    }

    /**
     * 根据菜品id删除当前商户的菜品
     * @param businessmanId 商户id
     * @param dishId        菜品id
     * @return              成功信息
     */
    @DeleteMapping
    public R removeDish(int businessmanId,int dishId){
        return dishService.removeDish(businessmanId,dishId);
    }
}
