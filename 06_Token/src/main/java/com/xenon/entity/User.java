package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.List;

@Data
@TableName("m_user")
public class User
{
    // 设定主键且主键自增
    // 若不设置主键会在数据库中自增，但在Java中的数据会不对
    // @TableId(type = IdType.AUTO)
    // private Integer userId = 0;
    private String username;
    private String password;

    @TableField(exist = false)
    private List<Order> orderList;

}
