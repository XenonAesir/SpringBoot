package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("teacher")
public class Teacher
{
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String major;
}
