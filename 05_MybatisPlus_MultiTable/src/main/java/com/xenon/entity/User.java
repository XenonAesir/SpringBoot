package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("m_user")
public class User
{
    @TableId(type = IdType.AUTO)
    private int userId;
    private String userName;
    private String userPassword;

    @TableField(exist = false)
    private List<Order> orders;
}
