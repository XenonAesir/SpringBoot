package com.xenon.controller;

import com.xenon.service.impl.UserRoleServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRole")
@CrossOrigin
@Api(tags = "用户字典—部门职位")
public class UserRoleController
{
    @Autowired
    UserRoleServiceImpl userRoleService;

    @ApiOperation("获取全部的部门职位字典")
    @GetMapping("/all")
    public Result getAllUserRole()
    {
        return userRoleService.getAllUserRole();
    }

}
