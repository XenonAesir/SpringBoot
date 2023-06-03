package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @TableName allocation
 */
@ApiModel("Allocation_分配关系类")
@TableName(value ="allocation")
@Data
public class Allocation implements Serializable {
    /**
     * 分配ID
     */
    @ApiModelProperty(value = "分配ID")
    @TableId(type = IdType.AUTO)
    private Long allocationId;

    /**
     * 物资ID
     */
    @ApiModelProperty(value = "所分配的物资ID")
    private Long materialId;

    /**
     * 管理员ID
     */
    @ApiModelProperty(value = "负责此次分配的管理员ID")
    private Long adminId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "分配给的用户ID")
    private Long userId;

    /**
     * 分配日期
     */
    @ApiModelProperty(value = "分配日期")
    private Date allocationDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}