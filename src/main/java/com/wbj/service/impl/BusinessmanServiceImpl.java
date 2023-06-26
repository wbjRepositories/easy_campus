package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.BusinessmanMapper;
import com.wbj.pojo.Businessman;
import com.wbj.service.BusinessmanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Slf4j
@Transactional
public class BusinessmanServiceImpl implements BusinessmanService {
    @Autowired
    BusinessmanMapper businessmanMapper;
    @Override
    public R<ArrayList<Businessman>> getBusinessmanByPage(int currentPage, int pageSize) {
        log.info("分页查询商户，当前页码：{} 每页数：{}",currentPage,pageSize);
        if (currentPage<0||pageSize<0){
            return R.fail("数据格式有误！");
        }
        return R.success(businessmanMapper.selectBusinessmenByPage((currentPage-1)*pageSize,pageSize),"分页查询商户成功！");
    }
}
