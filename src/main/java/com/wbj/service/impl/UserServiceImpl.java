package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.UserMapper;
import com.wbj.pojo.Class;
import com.wbj.pojo.User;
import com.wbj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public R<User> login(String username, String password,int role) {
        log.info("用户尝试登录，用户名：{} 密码：{} 角色：{}",username,password,role);
        User user = userMapper.selectOneByLoginInfo(username, password,role);
        if (user == null) {
            log.info("用户登录失败，用户名：{} 密码：{}",username,password);
            return R.fail("用户名或密码错误!");
        }
        return R.success(user,"登录成功！");
    }

    @Override
    public R<Integer> setUserInfo(User user) {
        log.info("修改用户信息为：{}",user);
        return R.success(userMapper.updateUserInfo(user),"修改用户信息成功！");
    }

    @Override
    public R<ArrayList<Class>> getAllClass() {
        log.info("查询所有班级信息");
        return R.success(userMapper.selectAllClass(),"查询班级成功！");
    }


}
