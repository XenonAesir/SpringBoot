package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName supplier
 */
@TableName(value ="supplier")
@Data
public class Supplier implements Serializable {
    /**
     * 供应商ID
     */
    @TableId(type = IdType.AUTO)
    private Long supplierId;

    /**
     * 供应商名
     */
    private String supplierName;

    /**
     * 供应商地址
     */
    private String supplierAddress;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系人电话
     */
    private String contactNumber;

    /**
     * 联系人邮件
     */
    private String contactEmail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}