package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName material
 */
@TableName(value ="material")
@Data
public class Material implements Serializable {
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

    /**
     * 物资类型ID
     */
    private Long materialTypeId;

    /**
     * 物资状态ID
     */
    private Long materialStatusId;

    /**
     * 管理员ID
     */
    private Long adminId;

    /**
     * 是否已分配
     */
    private Integer isAllocated;

    /**
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 是否为固定资产
     */
    private Integer isAsset;

    /**
     * 固定资产序列号
     */
    private String assetNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}