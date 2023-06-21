package com.wbj.controller;

import com.wbj.Utils.TokenUtils;
import com.wbj.common.R;
import com.wbj.pojo.Class;
import com.wbj.pojo.User;
import com.wbj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录
     * @param response
     * @param role      判断登录角色
     * @param user
     * @return
     */
    @PostMapping("login/{role}")
    public R<User> login(HttpServletResponse response, @PathVariable int role, @RequestBody User user) {
        R<User> login = userService.login(user.getUsername(), user.getPassword(), role);
        if (login.getCode() == 1) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", login.getData().getId() + "");
            claims.put("username", login.getData().getUsername());
            //生成token
            String token = TokenUtils.createToken(claims);
            response.addHeader("token", token);
        }
        return login;
    }

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public R<User> getUserInfo(@PathVariable int userId){
        return userService.getUserInfo(userId);
    }


    /**
     * 更改用户个人信息
     * @param user  只需提供id,name,gender,classId,phone,address,birthday
     * @return
     */
    @PutMapping
    public R<Integer> setUserInfo(@RequestBody User user){
        return userService.setUserInfo(user);
    }

    /**
     * 获取所有班级信息
     * @return
     */
    @GetMapping("classes")
    public R<ArrayList<Class>> getAllClass(){
        return userService.getAllClass();
    }
}
