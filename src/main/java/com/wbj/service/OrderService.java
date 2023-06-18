package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Businessman;
import com.wbj.pojo.Dish;

import java.util.ArrayList;

public interface OrderService {
    R<ArrayList<Businessman>> getBusinessmanByPage(int currentPage, int pageSize);

    R<ArrayList<Dish>> getDishByPage(int businessmanId, int currentPage, int pageSize);

    R<Integer> getDishCount(int businessmanId);
}
