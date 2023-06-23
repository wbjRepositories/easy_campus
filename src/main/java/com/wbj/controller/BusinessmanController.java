package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.service.BusinessmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("businessman")
public class BusinessmanController {
    @Autowired
    BusinessmanService businessmanService;

    /**
     * 按照分页获取商户信息
     * @param currentPage   当前页
     * @param pageSize      每页大小
     * @return
     */
    @GetMapping
    public R getBusinessmen(@RequestParam(required = false,defaultValue = "1") int currentPage
            , @RequestParam(required = false,defaultValue = "8") int pageSize){
        return businessmanService.getBusinessmanByPage(currentPage, pageSize);
    }
}
