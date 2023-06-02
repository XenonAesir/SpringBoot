package com.xenon.controller;

import com.xenon.entity.User;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController
{
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id)
    {
        return "根据id" + id.toString() + "获取用户信息";
    }

    @PostMapping("/")
    public String save(User user)
    {
        return "添加用户到数据库" + user.toString();
    }

    @PutMapping("/")
    public String update(User user)
    {
        return "更新用户到数据库" + user.toString();
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Integer id)
    {
        return "根据id" + id.toString() + "删除用户信息";
    }


}
