package com.wbj.common;

import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
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


    @ExceptionHandler(Exception.class)
    public R AllException(Exception e){
        log.error("未知异常：{}",e.toString()+":"+e.getMessage());
        e.printStackTrace();
        return R.fail("未知异常！请联系网站管理员！");
    }
}
