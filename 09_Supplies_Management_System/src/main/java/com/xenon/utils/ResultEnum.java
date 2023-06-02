package com.xenon.utils;

public enum ResultEnum
{
    SUCCESS(200, "成功"),
    ERROR(500, "错误");

    public final int code;
    public final String description;

    ResultEnum(int code, String description)
    {
        this.code = code;
        this.description = description;
    }
}
