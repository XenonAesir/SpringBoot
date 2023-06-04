package com.xenon.controller;

import com.xenon.service.impl.DepartmentServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@CrossOrigin
@Api(tags = "用户字典—部门所属")
public class DepartmentController
{
    @Autowired
    DepartmentServiceImpl departmentService;

    @ApiOperation("获取全部的部门字典")
    @GetMapping("/all")
    public Result getAllDepartment()
    {
        return departmentService.getAllDepartment();
    }


    @ApiOperation("获取部门员工及设备分配情况")
    @GetMapping("/{departmentID}")
    public Result getDepartmentAllUser(@PathVariable Integer departmentID)
    {
        return departmentService.getDepartmentAllUser(departmentID);
    }
}
