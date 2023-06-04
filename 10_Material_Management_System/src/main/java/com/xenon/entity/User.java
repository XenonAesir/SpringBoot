package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@ApiModel("User_用户类")
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    @TableId(type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    /**
     * 用户部门ID
     */
    @ApiModelProperty(value = "用户部门ID")
    private Long departmentId;
    @TableField(exist = false)
    private Department department;

    /**
     * 用户角色ID
     */
    @ApiModelProperty(value = "用户职位ID")
    private Long userRoleId;
    @TableField(exist = false)
    private UserRole userRole;

    /***
     * 用户所分配到的设备
     */
    @TableField(exist = false)
    private List<Material> materialList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}