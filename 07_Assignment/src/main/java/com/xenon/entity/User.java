package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User
{
    // 设定主键且主键自增
    // 若不设置主键会在数据库中自增，但在Java中的数据会不对
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String type;

}
