package com.wbj.service;

import com.wbj.common.R;
import com.wbj.pojo.User;

public interface UserService {
    R<User> login(String username, String password);
}
