package com.wbj.controller;

import com.wbj.Dto.UserDto;
import com.wbj.common.R;
import com.wbj.pojo.User;
import com.wbj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("login/{type}")
    public R<User> login(@PathVariable Integer type, @RequestBody UserDto userDto){
        String username = null;
        if (type == 1){
            //如果用户是学生，那么用户的学号就是账户名
            username = userDto.getNum();
        } else if (type == 2 || type == 3) {
            //如果用户是老师或者商户，那么手机号就是账户名
            username = userDto.getPhone();
        }
        return userService.login(username, userDto.getPassword());
    }
}
