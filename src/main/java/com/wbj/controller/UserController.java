package com.wbj.controller;

import com.wbj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("login/{type}")
    public void login(HttpServletRequest request, @PathVariable Integer type, String username, String password){
        System.out.println(username+"+"+password);
    }
}
