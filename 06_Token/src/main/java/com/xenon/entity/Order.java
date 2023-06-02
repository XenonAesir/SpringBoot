package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("m_order")
public class Order
{
    // 设置主键为自增
    @TableId(type = IdType.AUTO)
    private int orderId;
    private String orderName;

    // 表中的数据为单纯的用户id，这里增加为用户对象，需要告知MybatisPlus此属性不存在于表中
    @TableField(exist = false)
    private User consumer;
}
