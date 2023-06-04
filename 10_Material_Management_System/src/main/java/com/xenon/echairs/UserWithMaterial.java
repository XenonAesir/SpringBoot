package com.xenon.echairs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserWithMaterial
{
    private String userName;
    private String userDepartment;
    private String userRole;

    private String materialName;
    private String materialUnit;
    private BigDecimal materialPrice;
    private String materialStatus;
    private String materialType;
    private String materialSupplier;

    private Integer isAsset;
    private String assetNumber;

    private Long allocationId;
}
