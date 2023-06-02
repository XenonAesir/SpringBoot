package com.xenon.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result
{
    private Boolean success;
    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();


    // 私有化构造方法
    private Result()
    {

    }

    // 成功的静态方法
    public static Result pass()
    {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultEnum.SUCCESS.code);
        result.setMessage(ResultEnum.SUCCESS.description);
        return result;
    }

    // 失败的静态方法
    public static Result error()
    {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultEnum.ERROR.code);
        result.setMessage(ResultEnum.ERROR.description);
        return result;
    }

    public Result success(Boolean success)
    {
        this.setSuccess(success);
        return this;
    }

    public Result message(String message)
    {
        this.setMessage(message);
        return this;
    }

    public Result code(int code)
    {
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value)
    {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map)
    {
        this.setData(map);
        return this;
    }

}
