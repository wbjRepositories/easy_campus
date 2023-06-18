package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.Class;
import com.wbj.pojo.User;

import java.util.ArrayList;

public interface UserService {
    R<User> login(String username, String password,int role);

    R<Integer> setUserInfo(User user);

    R<ArrayList<Class>> getAllClass();
}
