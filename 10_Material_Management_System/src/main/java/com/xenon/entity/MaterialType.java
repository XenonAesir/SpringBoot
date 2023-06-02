package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName material_type
 */
@TableName(value ="material_type")
@Data
public class MaterialType implements Serializable {
    /**
     * 物资类型ID
     */
    @TableId(type = IdType.AUTO)
    private Long materialTypeId;

    /**
     * 物资状态名
     */
    private String materialTypeName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}