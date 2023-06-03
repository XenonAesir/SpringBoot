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
 * @TableName material_type
 */
@ApiModel("MaterialType_物资类型类")
@TableName(value ="material_type")
@Data
public class MaterialType implements Serializable {
    /**
     * 物资类型ID
     */
    @ApiModelProperty(value = "物资类型ID")
    @TableId(type = IdType.AUTO)
    private Long materialTypeId;

    /**
     * 物资状态名
     */
    @ApiModelProperty(value = "物资类型名")
    private String materialTypeName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}