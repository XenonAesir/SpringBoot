package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @TableName material
 */
@ApiModel("Material_物资类")
@TableName(value ="material")
@Data
public class Material implements Serializable {
    /**
     * 物资ID
     */
    @ApiModelProperty(value = "物资ID")
    @TableId(type = IdType.AUTO)
    private Long materialId;

    /**
     * 物资名
     */
    @ApiModelProperty(value = "物资名")
    private String materialName;

    /**
     * 物资价格
     */
    @ApiModelProperty(value = "物资价格")
    private BigDecimal materialPrice;

    /**
     * 物资单位ID
     */
    @ApiModelProperty(value = "物资所属的单位ID")
    private Long materialUnitId;

    /**
     * 物资类型ID
     */
    @ApiModelProperty(value = "物资所属的类型ID")
    private Long materialTypeId;

    /**
     * 物资状态ID
     */
    @ApiModelProperty(value = "物资所属的类型ID")
    private Long materialStatusId;

    /**
     * 管理员ID
     */
    @ApiModelProperty(value = "录入/采购物资的管理员")
    private Long adminId;

    /**
     * 是否已分配
     */
    @ApiModelProperty(value = "是否已分配，0未分配，1已分配")
    private Integer isAllocated;

    /**
     * 供应商ID
     */
    @ApiModelProperty(value = "物资所属的供应商ID")
    private Long supplierId;
    @TableField(exist = false)
    Supplier supplier;

    /**
     * 是否为固定资产
     */
    @ApiModelProperty(value = "是否为固定资产，0不是，1是")
    private Integer isAsset;

    /**
     * 固定资产序列号
     */
    @ApiModelProperty(value = "固定资产序列号，只有固定资产有次项，否则为null")
    private String assetNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}