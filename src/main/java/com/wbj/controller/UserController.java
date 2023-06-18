package com.wbj.controller;

import com.wbj.common.R;
import com.wbj.pojo.User;
import com.wbj.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login/{role}")
    public R<User> login(HttpServletResponse response, @PathVariable int role, @RequestBody User user) {
        R<User> login = userService.login(user.getUsername(), user.getPassword(), role);
        if (login.getCode() == 1) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id", login.getData().getId() + "");
            claims.put("username", login.getData().getUsername());
            String token = Jwts.builder()
                    .setClaims(claims)
                    .signWith(SignatureAlgorithm.HS256, "easy_campus")
                    .setExpiration(new Date(System.currentTimeMillis() + 3 * 24 * 3600 * 1000))
                    .compact();
            response.addHeader("token", token);
        }
        return login;
    }



}
