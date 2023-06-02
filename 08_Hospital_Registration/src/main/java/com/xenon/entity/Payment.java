package com.xenon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment
{
    @TableId(type = IdType.AUTO)
    private long id;
    private String type;
    private BigDecimal amount;
    private java.sql.Date paymentTime;
    private long registrationId;

    @TableField(exist = false)
    private Registration registration;
}
