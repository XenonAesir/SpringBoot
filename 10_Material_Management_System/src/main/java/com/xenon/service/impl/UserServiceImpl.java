package com.xenon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Admin;
import com.xenon.entity.User;
import com.xenon.mapper.DepartmentMapper;
import com.xenon.mapper.UserRoleMapper;
import com.xenon.service.UserService;
import com.xenon.mapper.UserMapper;
import com.xenon.utils.JwtUtils;
import com.xenon.utils.Result;
import com.xenon.utils.StaticVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xenon
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-01 11:26:20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService
{
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    UserRoleMapper userRoleMapper;


    public Result handleLogin(User user)
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User userInfo = getOne(new QueryWrapper<User>()
                .eq("user_name", user.getUserName())
        );

        if (userInfo != null)
        {
            String rawPassword = user.getUserPassword();
            String encodedPassword = userInfo.getUserPassword();
            boolean matches = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);

            System.out.println(matches + "原生密码" + rawPassword + "加密密码" + encodedPassword);

            if (matches)
            {
                String token = JwtUtils.getToken(userInfo.getUserName());
                return Result.pass()
                        .data("token", token)
                        .data("userName", userInfo.getUserName())
                        .data("userDepartment", departmentMapper.selectById(userInfo.getDepartmentId()))
                        .data("userRole", userRoleMapper.selectById(userInfo.getUserRoleId()));
            }
            else
            {
                return Result.error("密码错误");
            }
        }
        return Result.error("用户不存在");
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

    public Result handleRegister(User user)
    {
        User userName = this.getOne(new QueryWrapper<User>().eq("user_name", user.getUserName()));
        if (userName != null)
        {
            return Result.error("用户名已存在");
        }
        else
        {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String rawPassword = user.getUserPassword();
            String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
            user.setUserPassword(encodedPassword);
        }
        return Result.pass().data("data", this.save(user));
    }

    public Result getAllUser()
    {
        List<User> userList = this.list();


        for (User user : userList)
        {
            user.setUserPassword("");
            user.setDepartment(departmentMapper.selectById(user.getDepartmentId()));
            user.setUserRole(userRoleMapper.selectById(user.getUserRoleId()));
        }


        return Result.pass().data("data", userList);
    }
}




