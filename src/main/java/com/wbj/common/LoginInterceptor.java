package com.wbj.common;

import com.wbj.Utils.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建拦截器并交给spring容器管理
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        String method = request.getMethod();
        if ("".equalsIgnoreCase(method)){

        }
        System.out.println();


        //解析token，没有发生异常说明token值正确
        TokenUtils.parseToken(token);
        System.out.println("拦截器测试。。。。。。。。。。");
        return true;
    }
}
