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
 * @TableName material_unit
 */
@TableName(value ="material_unit")
@Data
@ApiModel("MaterialUnit_物资单位类")
public class MaterialUnit implements Serializable {
    /**
     * 物资单位ID
     */
    @ApiModelProperty(value = "物资单位ID")
    @TableId(type = IdType.AUTO)
    private Long materialUnitId;

    /**
     * 物资单位名
     */
    @ApiModelProperty(value = "物资单位名")
    private String materialUnitName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}