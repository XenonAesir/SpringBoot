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
@TableName(value ="allocation")
@Data
@ApiModel("Allocation_物资-部门分配表")
public class Allocation implements Serializable {
    /**
     * 物资-部门分配表id
     */
    @TableId(type = IdType.AUTO)
    private Integer allocationId;

    /**
     * 物资id
     */
    private Integer materialId;

    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 分配日期
     */
    private Date allocationDate;

    /**
     * 分配人id
     */
    private Integer userId;

    /**
     * 分配数量
     */
    private Integer allocateAmount;

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
        Allocation other = (Allocation) that;
        return (this.getAllocationId() == null ? other.getAllocationId() == null : this.getAllocationId().equals(other.getAllocationId()))
            && (this.getMaterialId() == null ? other.getMaterialId() == null : this.getMaterialId().equals(other.getMaterialId()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getAllocationDate() == null ? other.getAllocationDate() == null : this.getAllocationDate().equals(other.getAllocationDate()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAllocateAmount() == null ? other.getAllocateAmount() == null : this.getAllocateAmount().equals(other.getAllocateAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAllocationId() == null) ? 0 : getAllocationId().hashCode());
        result = prime * result + ((getMaterialId() == null) ? 0 : getMaterialId().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getAllocationDate() == null) ? 0 : getAllocationDate().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAllocateAmount() == null) ? 0 : getAllocateAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", allocationId=").append(allocationId);
        sb.append(", materialId=").append(materialId);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", allocationDate=").append(allocationDate);
        sb.append(", userId=").append(userId);
        sb.append(", allocateAmount=").append(allocateAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}