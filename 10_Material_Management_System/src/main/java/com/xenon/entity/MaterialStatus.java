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
 * @TableName material_status
 */
@ApiModel("MaterialStatus_物资状态类")
@TableName(value ="material_status")
@Data
public class MaterialStatus implements Serializable {
    /**
     * 物资状态ID
     */
    @ApiModelProperty(value = "物资状态ID")
    @TableId(type = IdType.AUTO)
    private Long materialStatusId;

    /**
     * 物资状态名
     */
    @ApiModelProperty(value = "物资状态名")
    private String materialStatusName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}