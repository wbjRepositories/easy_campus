package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Dish;

import java.util.ArrayList;

public interface DishService {


    R<ArrayList<Dish>> getDishByPage(int businessmanId, int currentPage, int pageSize);

    R<Integer> getDishCount(int businessmanId);

    R<String> removeDish(int businessmanId,int dishId);
}
