package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.ClassMapper;
import com.wbj.pojo.Class;
import com.wbj.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@Slf4j
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;

    @Override
    public R<ArrayList<Class>> getAllClass() {
        log.info("查询所有班级信息");
        return R.success(classMapper.selectAllClass(),"查询班级成功！");
    }
}
