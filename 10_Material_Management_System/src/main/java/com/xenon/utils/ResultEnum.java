package com.xenon.utils;

public enum ResultEnum
{
    SUCCESS(200, "操作成功"),
    ERROR(500, "服务器内部错误"),
    DB_FK_ERROR(509, "数据库外键约束错误"),
    DB_IC_ERROR(510, "数据完整性错误");

    public final int code;
    public final String description;

    ResultEnum(int code, String description)
    {
        this.code = code;
        this.description = description;
    }
}
