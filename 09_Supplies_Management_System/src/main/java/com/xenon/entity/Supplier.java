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
 * @TableName supplier
 */
@TableName(value ="supplier")
@Data
@ApiModel("Supplier_供应商")
public class Supplier implements Serializable {
    /**
     * 供应商id
     */
    @TableId(type = IdType.AUTO)
    private Integer supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商联系人
     */
    private String contactPerson;

    /**
     * 供应商联系人电话
     */
    private String contactNumber;

    /**
     * 供应商地址
     */
    private String supplierAddress;

    /**
     * 供应商电子邮件
     */
    private String supplierEmail;

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
        Supplier other = (Supplier) that;
        return (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()))
            && (this.getSupplierName() == null ? other.getSupplierName() == null : this.getSupplierName().equals(other.getSupplierName()))
            && (this.getContactPerson() == null ? other.getContactPerson() == null : this.getContactPerson().equals(other.getContactPerson()))
            && (this.getContactNumber() == null ? other.getContactNumber() == null : this.getContactNumber().equals(other.getContactNumber()))
            && (this.getSupplierAddress() == null ? other.getSupplierAddress() == null : this.getSupplierAddress().equals(other.getSupplierAddress()))
            && (this.getSupplierEmail() == null ? other.getSupplierEmail() == null : this.getSupplierEmail().equals(other.getSupplierEmail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        result = prime * result + ((getSupplierName() == null) ? 0 : getSupplierName().hashCode());
        result = prime * result + ((getContactPerson() == null) ? 0 : getContactPerson().hashCode());
        result = prime * result + ((getContactNumber() == null) ? 0 : getContactNumber().hashCode());
        result = prime * result + ((getSupplierAddress() == null) ? 0 : getSupplierAddress().hashCode());
        result = prime * result + ((getSupplierEmail() == null) ? 0 : getSupplierEmail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", contactPerson=").append(contactPerson);
        sb.append(", contactNumber=").append(contactNumber);
        sb.append(", supplierAddress=").append(supplierAddress);
        sb.append(", supplierEmail=").append(supplierEmail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}