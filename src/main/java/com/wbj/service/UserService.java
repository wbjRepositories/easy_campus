package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Class;
import com.wbj.pojo.User;

import java.util.ArrayList;

public interface UserService {
    R<User> login(String username, String password,int role);

    R<Integer> setUserInfo(User user);

    /**
     * 通过用户id获取用户信息
     * @param userId
     * @return
     */
    R<User> getUserInfo(int userId);

    R<ArrayList<Class>> getAllClass();
}
