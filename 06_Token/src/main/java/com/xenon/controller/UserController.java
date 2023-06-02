package com.xenon.controller;

import com.xenon.entity.User;
import com.xenon.mapper.UserMapper;
import com.xenon.utils.JwtUtils;
import com.xenon.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController
{
    @Autowired
    UserMapper userMapper;

    // @GetMapping("/all")
    // public List<User> getAllUsers()
    // {
    //     return userMapper.getAllUsers();
    // }
    //
    @PostMapping("/login")
    // 设置@RequestBody则以JSON形式接收数据
    public Result login(@RequestBody User user)
    {
        String token = JwtUtils.getToken(user.getUsername());
        return Result.pass().data("token", token);
    }

    // @PostMapping("/info")
    // public Result info(@RequestBody String token)
    // {
    //     String userInfo = JwtUtils.getClaims(token).getSubject();
    //     return Result.pass().data("userInfo", userInfo);
    // }

    @GetMapping("/info")
    public Result info(String token)
    {
        String username = JwtUtils.getClaims(token).getSubject();
        String url = "https://img0.baidu.com/it/u=697903734,1544489081&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500";
        return Result.pass().data("name", username).data("avatar", url);
    }

    @PostMapping("/logout")
    public Result logout()
    {
        return Result.pass();
    }
}
