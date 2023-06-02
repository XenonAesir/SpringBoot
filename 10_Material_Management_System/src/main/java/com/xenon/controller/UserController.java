package com.xenon.controller;

import com.xenon.entity.User;
import com.xenon.service.impl.UserServiceImpl;
import com.xenon.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户登陆、登出及Token解析")
public class UserController
{
    @Autowired
    UserServiceImpl userServiceImpl;

    @ApiOperation("用户登录")
    @ApiImplicitParam(name = "user", value = "用户表单", paramType = "body", required = true, dataType = "User")
    @PostMapping("/login")
    // 设置@RequestBody则以JSON形式接收数据
    public Result login(@RequestBody User user)
    {
        return userServiceImpl.handleLogin(user);
    }

    @ApiOperation("解析Token")
    @ApiImplicitParam(name = "token", value = "token", required = true)
    @GetMapping("/info")
    public Result info(String token)
    {
        return userServiceImpl.handleInfo(token);
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public Result logout()
    {
        return userServiceImpl.handleLogout();
    }
}
