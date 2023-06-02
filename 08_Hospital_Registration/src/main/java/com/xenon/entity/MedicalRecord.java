package com.xenon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class MedicalRecord
{
    @TableId(type = IdType.AUTO)
    private long id;
    private String prescription;
    private java.sql.Timestamp time;
    private long registrationId;

    @TableField(exist = false)
    private Registration registration;
}
