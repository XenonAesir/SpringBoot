package com.xenon.controller;

import com.xenon.entity.User;
import com.xenon.service.UserService;
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
    UserService userService;

    @PostMapping("/login")
    // 设置@RequestBody则以JSON形式接收数据
    public Result login(@RequestBody User user)
    {
        User userInfo = userService.selectUserByWrapper(user);
        if (user.getPassword().equals(userInfo.getPassword()))
        {
            String token = JwtUtils.getToken(user.getUsername());
            return Result.pass().data("token", token).data("data", userInfo);
        }
        return Result.error();
    }

    @GetMapping("/info")
    public Result info(String token)
    {
        String Username = JwtUtils.getClaims(token).getSubject();
        String url = "https://img2.baidu.com/it/u=3568915938,1069002558&fm=253&fmt=auto&app=138&f=JPEG?w=380&h=380";
        return Result.pass().data("name", Username).data("avatar", url).data("type", "管理员");
    }

    @PostMapping("/logout")
    public Result logout()
    {
        return Result.pass();
    }
}
