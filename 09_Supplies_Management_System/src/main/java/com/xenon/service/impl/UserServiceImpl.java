package com.xenon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.User;
import com.xenon.service.UserService;
import com.xenon.mapper.UserMapper;
import com.xenon.utils.JwtUtils;
import com.xenon.utils.Result;
import org.springframework.stereotype.Service;

/**
 * @author Xenon
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-05-30 22:23:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{
    public Result handleLogin(User user)
    {
        User userInfo = getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (user.getPassword().equals(userInfo.getPassword()))
        {
            String token = JwtUtils.getToken(userInfo.getUsername());
            return Result.pass()
                    .data("token", token)
                    .data("username", userInfo.getUsername())
                    .data("role", userInfo.getRole().name());
        }
        return Result.error("用户名或密码错误");
    }

    public Result handleInfo(String token)
    {
        String Username = JwtUtils.getClaims(token).getSubject();
        String url = "https://img2.baidu.com/it/u=3568915938,1069002558&fm=253&fmt=auto&app=138&f=JPEG?w=380&h=380";
        return Result.pass()
                .data("name", Username)
                .data("avatar", url);
    }

    public Result handleLogout()
    {
        return Result.pass();
    }
}




