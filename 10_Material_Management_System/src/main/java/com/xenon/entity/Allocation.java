package com.xenon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName allocation
 */
@TableName(value ="allocation")
@Data
public class Allocation implements Serializable {
    /**
     * 分配ID
     */
    @TableId(type = IdType.AUTO)
    private Long allocationId;

    /**
     * 物资ID
     */
    private Long materialId;

    /**
     * 管理员ID
     */
    private Long adminId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 分配日期
     */
    private Date allocationDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}