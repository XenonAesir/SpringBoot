package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @TableName material
 */
@TableName(value = "material")
@Data
public class Material implements Serializable
{
    /**
     * 物资ID
     */
    @TableId(type = IdType.AUTO)
    private Long materialId;

    /**
     * 物资名
     */
    private String materialName;

    /**
     * 物资价格
     */
    private BigDecimal materialPrice;

    /**
     * 物资单位ID
     */
    private Long materialUnitId;
    // @TableField(exist = false)
    // private MaterialUnit materialUnit;

    /**
     * 物资类型ID
     */
    private Long materialTypeId;
    // @TableField(exist = false)
    // private MaterialType materialType;

    /**
     * 物资状态ID
     */
    private Long materialStatusId;
    // @TableField(exist = false)
    // private MaterialStatus materialStatus;

    /**
     * 管理员ID
     */
    private Long adminId;
    // @TableField(exist = false)
    // private Admin admin;

    /**
     * 是否已分配
     */
    private Integer isAllocated;

    /**
     * 供应商ID
     */
    private Long supplierId;
    // @TableField(exist = false)
    // private Supplier supplier;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}