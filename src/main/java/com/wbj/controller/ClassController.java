package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.pojo.Class;
import com.wbj.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;


    /**
     * 获取所有班级信息
     * @return  班级信息
     */
    @GetMapping
    public R<ArrayList<Class>> getAllClass(){
        return classService.getAllClass();
    }
}
