package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.pojo.User;
import com.wbj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("login/{role}")
    public R<User> login(@PathVariable int role, @RequestBody User user){
        return userService.login(user.getUsername(), user.getPassword(),role);
    }
}
