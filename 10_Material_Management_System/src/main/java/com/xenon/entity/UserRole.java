package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_role
 */
@TableName(value ="user_role")
@Data
public class UserRole implements Serializable {
    /**
     * 用户角色ID
     */
    @TableId(type = IdType.AUTO)
    private Long userRoleId;

    /**
     * 用户角色名
     */
    private String userRoleName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}