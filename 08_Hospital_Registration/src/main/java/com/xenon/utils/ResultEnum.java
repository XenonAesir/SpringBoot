package com.xenon.utils;

public enum ResultEnum
{
    SUCCESS(20000, "成功"),
    ERROR(30000, "错误");

    public int code;
    public String description;

    ResultEnum(int code, String description)
    {
        this.code = code;
        this.description = description;
    }
}
