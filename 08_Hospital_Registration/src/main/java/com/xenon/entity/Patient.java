package com.xenon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Patient
{
    @TableId(type = IdType.AUTO)
    private long id;
    private String name;
    private String gender;
    private long age;
    private String contact;

}
