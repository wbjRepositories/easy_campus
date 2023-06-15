package com.wbj.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class R<T> {
    //成功返回1，错误返回0
    private Integer code;
    //返回错误或成功消息
    private String msg;
    //数据内容
    private T Data;

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        Data = data;
    }
    //操作成功，并返回数据
    public static<V> R success(V data,String msg){
        return new R<>(1,msg,data);
    }
    //操作成功
    public static R success(String msg){
        return new R<>(1,msg,null);
    }

    //操作失败
    public static R fail(String msg){
        return new R<>(0,msg,null);
    }
}
