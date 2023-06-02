package com.xenon.controller;

import com.xenon.entity.Admin;
import com.xenon.service.impl.AdminServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
@Api(tags = "管理员登陆、登出及Token解析")
public class AdminController
{
    @Autowired
    AdminServiceImpl adminServiceImpl;

    @ApiOperation("管理员登录")
    @ApiImplicitParam(name = "admin", value = "管理员表单", paramType = "body", required = true, dataType = "Admin")
    @PostMapping("/login")
    // 设置@RequestBody则以JSON形式接收数据
    public Result login(@RequestBody Admin admin)
    {
        return adminServiceImpl.handleLogin(admin);
    }

    @ApiOperation("解析Token")
    @ApiImplicitParam(name = "token", value = "token", required = true)
    @GetMapping("/info")
    public Result info(String token)
    {
        return adminServiceImpl.handleInfo(token);
    }

    @ApiOperation("管理员登出")
    @PostMapping("/logout")
    public Result logout()
    {
        return adminServiceImpl.handleLogout();
    }
}
