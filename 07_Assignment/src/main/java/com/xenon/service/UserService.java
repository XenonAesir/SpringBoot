package com.xenon.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xenon.entity.Teacher;
import com.xenon.entity.User;
import com.xenon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService
{
    @Autowired
    UserMapper userMapper;

    public User selectUserByWrapper(@RequestBody User user)
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();// 构建一个查询的wrapper

        wrapper
                .eq("username", user.getUsername());
        return userMapper.selectOne(wrapper);
    }
}
