package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("businessmen")
    public R getBusinessmen(@RequestParam(required = false,defaultValue = "1") int currentPage
            ,@RequestParam(required = false,defaultValue = "8") int pageSize){
        return orderService.getBusinessmanByPage(currentPage, pageSize);
    }


    @GetMapping("dish")
    public R getDish(int businessmanId,@RequestParam(required = false,defaultValue = "1") int currentPage
            ,@RequestParam(required = false,defaultValue = "8") int pageSize){
        return orderService.getDishByPage(businessmanId,currentPage,pageSize);
    }
}
