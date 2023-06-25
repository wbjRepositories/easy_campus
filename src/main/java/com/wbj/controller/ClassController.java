package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.pojo.Class;
import com.wbj.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("all")
    public R<ArrayList<Class>> getAllClass(){
        return classService.getAllClass();
    }

    /**
     * 添加班级
     * @param c 要添加的班级信息
     *
     */
    @PostMapping
    public R addClass(Class c){
        return classService.addClass(c);
    }

    /**
     * 更新班级信息
     * @param c 要更新的班级信息
     *
     */
    @PutMapping
    public R updateClass(Class c) {
        return classService.updateClass(c);
    }

    /**
     * 批量删除班级
     * @param ids   班级id
     *
     */
    @DeleteMapping
    public R removeClass(int ...ids) {
        return classService.removeClass(ids);
    }

}
