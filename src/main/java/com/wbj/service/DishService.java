package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Dish;

import java.util.ArrayList;

public interface DishService {


    R<ArrayList<Dish>> getDishByPage(int businessmanId, int currentPage, int pageSize);

    R<Integer> getDishCount(int businessmanId);

    R removeDish(int businessmanId,int dishId);

    R removeMultiple(int businessmanId,int ...dis);

    R updateDish(int currentId,Dish dish);

    R addDish(int currentId,Dish dish);
}
