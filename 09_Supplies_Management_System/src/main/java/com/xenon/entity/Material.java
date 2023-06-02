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
@TableName(value ="material")
@Data
@ApiModel("Material_物资")
public class Material implements Serializable {
    /**
     * 物资id
     */
    @ApiModelProperty(example = "1")
    @TableId(type = IdType.AUTO)
    private Integer materialId;

    /**
     * 物资名称
     */
    @ApiModelProperty(example = "工作站")
    private String materialName;

    /**
     * 物资状态
     */
    @ApiModelProperty(example = "正常使用")
    private String materialStatus;

    /**
     * 物资单价
     */
    private BigDecimal materialPrice;

    /**
     * 物资类别
     */
    @ApiModelProperty(example = "固定资产")
    private String materialCategory;

    /**
     * 物资供应商
     */
    @ApiModelProperty(example = "戴尔")
    @TableField(exist = false)
    private Supplier supplier;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Material other = (Material) that;
        return (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()))
            && (this.getMaterialName() == null ? other.getMaterialName() == null : this.getMaterialName().equals(other.getMaterialName()))
            && (this.getMaterialStatus() == null ? other.getMaterialStatus() == null : this.getMaterialStatus().equals(other.getMaterialStatus()))
            && (this.getMaterialPrice() == null ? other.getMaterialPrice() == null : this.getMaterialPrice().equals(other.getMaterialPrice()))
            && (this.getMaterialCategory() == null ? other.getMaterialCategory() == null : this.getMaterialCategory().equals(other.getMaterialCategory()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        result = prime * result + ((getMaterialName() == null) ? 0 : getMaterialName().hashCode());
        result = prime * result + ((getMaterialStatus() == null) ? 0 : getMaterialStatus().hashCode());
        result = prime * result + ((getMaterialPrice() == null) ? 0 : getMaterialPrice().hashCode());
        result = prime * result + ((getMaterialCategory() == null) ? 0 : getMaterialCategory().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", materialId=").append(materialId);
        sb.append(", materialName=").append(materialName);
        sb.append(", materialStatus=").append(materialStatus);
        sb.append(", materialPrice=").append(materialPrice);
        sb.append(", materialCategory=").append(materialCategory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}