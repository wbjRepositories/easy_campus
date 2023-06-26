package com.wbj.common;

import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({IllegalArgumentException.class, MalformedJwtException.class})
    public R jwtException(Exception e){
        log.warn("非法参数异常：{}",e.toString()+":"+e.getMessage());
        return R.fail("jwt验证失败！");
    }

    @ExceptionHandler(IllegalStateException.class)
    public R formatException(Exception e){
        log.warn("非法状态异常：{}",e.toString()+":"+e.getMessage());
        return R.fail("数据格式有误！");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R MethodException(Exception e){
        log.info("不支持Http请求方法异常：{}",e.toString()+":"+e.getMessage());
        return R.fail("Http请求方法有误！");
    }


    @ExceptionHandler(Exception.class)
    public R AllException(Exception e){
        log.error("未知异常：{}",e.toString()+":"+e.getMessage());
        e.printStackTrace();
        return R.fail("未知异常！请联系网站管理员！");
    }
}
