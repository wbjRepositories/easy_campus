package com.wbj.service.impl;

import com.wbj.common.R;
import com.wbj.mapper.UserMapper;
import com.wbj.pojo.User;
import com.wbj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public R<User> login(String username, String password) {
        log.info("用户尝试登录，用户名：{} 密码：{}",username,password);
        User user = userMapper.selectOneByLoginInfo(username, password);
        if (user == null) {
            log.info("用户登录失败，用户名：{} 密码：{}",username,password);
            return R.fail("用户名或密码错误!");
        }
        return R.success(user,"登录成功！");
    }
}
