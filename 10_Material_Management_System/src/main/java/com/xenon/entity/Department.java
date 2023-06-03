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
 * @TableName department
 */
@ApiModel("Department_部门类")
@TableName(value ="department")
@Data
public class Department implements Serializable {
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID")
    @TableId(type = IdType.AUTO)
    private Long departmentId;

    /**
     * 部门名
     */
    @ApiModelProperty(value = "部门名")
    private String departmentName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}