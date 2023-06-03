package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName admin
 */
@ApiModel("User_用户类")
@TableName(value ="admin")
@Data
public class Admin implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    @TableId(type = IdType.AUTO)
    private Long adminId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String adminName;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String adminPassword;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}