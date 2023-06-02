package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//默认为类名首字母小写。设定为对应到哪个表
@TableName("user")
@Data
public class User
{
    // 设定主键且主键自增
    // 若不设置主键会在数据库中自增，但在Java中的数据会不对
    @TableId(type = IdType.AUTO)
    private Integer userID;
    // @TableField("nickName") 重映射userName到表中的nickName
    private String userName;
    private String userPassword;
}
