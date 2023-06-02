package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 
 * @TableName provision
 */
@TableName(value ="provision")
@Data
@ApiModel("Provision_物资-供应商")
public class Provision implements Serializable {
    /**
     * 物资-供应商id
     */
    @TableId(type = IdType.AUTO)
    private Integer provisionId;

    /**
     * 物资id
     */
    private Integer materialId;

    /**
     * 供应商id
     */
    private Integer supplierId;

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
        Provision other = (Provision) that;
        return (this.getProvisionId() == null ? other.getProvisionId() == null : this.getProvisionId().equals(other.getProvisionId()))
            && (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()))
            && (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProvisionId() == null) ? 0 : getProvisionId().hashCode());
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", provisionId=").append(provisionId);
        sb.append(", materialId=").append(materialId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}