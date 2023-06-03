package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.UserRole;
import com.xenon.service.UserRoleService;
import com.xenon.mapper.UserRoleMapper;
import com.xenon.utils.Result;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

    public Result getAllUserRole()
    {
        return Result.pass("用户角色字典已传输").data("data", this.list());

    }
}




