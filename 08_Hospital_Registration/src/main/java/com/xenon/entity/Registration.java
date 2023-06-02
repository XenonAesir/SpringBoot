package com.xenon.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Registration
{
    @TableId(type = IdType.AUTO)
    private long id;
    private long patientId;
    private long doctorId;
    private String department;
    private java.sql.Timestamp registrationTime;


    @TableField(exist = false)
    private Patient patient;

    @TableField(exist = false)
    private Doctor doctor;
}
