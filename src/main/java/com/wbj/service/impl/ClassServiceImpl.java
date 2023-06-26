package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.ClassMapper;
import com.wbj.pojo.Class;
import com.wbj.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
@Transactional
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;

    @Override
    public R<ArrayList<Class>> getAllClass() {
        log.info("查询所有班级信息");
        return R.success(classMapper.selectAllClass(), "查询班级成功！");
    }

    @Override
    public R addClass(Class c) {
        log.info("添加班级，班级名：{} 班级号：{}", c.getName(), c.getClassNum());
        classMapper.insertClass(c);
        return R.success("添加班级成功！");
    }

    @Override
    public R updateClass(Class c) {
        log.info("修改班级信息");
        int flag = classMapper.updateClass(c);
        if (flag > 0) {
            return R.success("修改班级信息成功！");
        }
        return R.fail("修改班级信息失败！");
    }

    @Override
    public R removeClass(int... ids) {
        log.info("删除班级信息");
        int flag = classMapper.deleteClassByIds(ids);
        if (flag > 0) {
            return R.success("删除班级成功！");
        }
        return R.fail("删除班级失败！");
    }
}
