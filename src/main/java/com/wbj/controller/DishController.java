package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.pojo.Dish;
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
     * @return              按分页返回菜品信息
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

//    /**
//     * 根据菜品id删除当前商户的菜品
//     * @param businessmanId 商户id
//     * @param dishId        菜品id
//     *
//     */
//    @DeleteMapping
//    public R removeDish(int businessmanId,int dishId){
//        return dishService.removeDish(businessmanId,dishId);
//    }

    /**
     * 批量删除菜品,可以删除一个或者多个
     * @param businessmanId 商户id
     * @param ids           菜品id
     * @return              影响的行数
     */
    @DeleteMapping("multiple")
    public R removeMultiple(int businessmanId, int... ids){
        return dishService.removeMultiple(businessmanId,ids);
    }



    /**
     * 更新当前商户的某一菜品
     * @param currentId 商户id
     * @param dish      菜品数据
     *
     */
    @PutMapping
    public R updateDish(int currentId, @RequestBody Dish dish) {
        return dishService.updateDish(currentId,dish);
    }

    /**
     * 新增菜品
     * @param currentId 商户id
     * @param dish      菜品id
     * @return          返回插入菜品的主键值
     */
    @PostMapping
    public R addDish(int currentId, @RequestBody Dish dish) {
        return dishService.addDish(currentId,dish);
    }
}
