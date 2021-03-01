package com.fys.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一般来说，返回前端的应该都是json格式，所以定义此工具类作为返回
 * 有错误码，描述信息和数据
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    /**
     * 此处多加一个构造器只包含code和message
     * 因为有时候code是为空
     * @param code
     * @param message
     */
   public CommonResult(Integer code,String message){
       this(code, message, null);
   }
}
