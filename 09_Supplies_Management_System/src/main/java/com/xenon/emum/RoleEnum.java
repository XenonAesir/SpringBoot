package com.xenon.emum;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum RoleEnum
{
    ADMIN(1, "管理员"),
    EMPLOYEE(0, "普通员工");

    @EnumValue
    @JsonValue
    private final int value;
    private final String desc;


    RoleEnum(int value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }
}
