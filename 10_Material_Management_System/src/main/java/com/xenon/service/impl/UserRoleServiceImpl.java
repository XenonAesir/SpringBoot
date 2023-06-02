package com.xenon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xenon.entity.UserRole;
import com.xenon.service.UserRoleService;
import com.xenon.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Xenon
* @description 针对表【user_role】的数据库操作Service实现
* @createDate 2023-06-01 13:33:42
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




