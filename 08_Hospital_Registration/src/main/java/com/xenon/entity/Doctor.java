package com.xenon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Doctor
{
    @TableId(type = IdType.AUTO)
    private long id;
    private String name;
    private int age;
    private String gender;
    private String major;

}
