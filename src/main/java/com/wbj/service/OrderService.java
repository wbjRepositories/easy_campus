package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Businessman;
import com.wbj.pojo.Dish;

public interface OrderService {
    R<Businessman> getBusinessmanByPage(int currentPage, int pageSize);

    R<Dish> getDishByPage(int businessmanId,int currentPage, int pageSize);
}
