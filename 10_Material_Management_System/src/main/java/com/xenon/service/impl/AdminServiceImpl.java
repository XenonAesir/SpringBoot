package com.xenon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.Admin;
import com.xenon.entity.Admin;
import com.xenon.service.AdminService;
import com.xenon.mapper.AdminMapper;
import com.xenon.utils.JwtUtils;
import com.xenon.utils.Result;
import com.xenon.utils.StaticVariable;
import org.springframework.stereotype.Service;

/**
 * @author Xenon
 * @description 针对表【admin】的数据库操作Service实现
 * @createDate 2023-06-01 11:26:19
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService
{
    public Result handleLogin(Admin admin)
    {
        Admin adminInfo = getOne(new QueryWrapper<Admin>()
                .eq("admin_name", admin.getAdminName())
                .eq("admin_password", admin.getAdminPassword())
        );
        if (adminInfo != null)
        {
            String token = JwtUtils.getToken(adminInfo.getAdminName());
            StaticVariable.ADMIN_ID = adminInfo.getAdminId();
            return Result.pass()
                    .data("token", token)
                    .data("adminName", adminInfo.getAdminName());
        }
        return Result.error("用户名或密码错误");
    }

    public Result handleInfo(String token)
    {
        String Adminname = JwtUtils.getClaims(token).getSubject();
        String url = "https://img2.baidu.com/it/u=3568915938,1069002558&fm=253&fmt=auto&app=138&f=JPEG?w=380&h=380";
        return Result.pass()
                .data("name", Adminname)
                .data("avatar", url);
    }

    public Result handleLogout()
    {
        return Result.pass();
    }
}




