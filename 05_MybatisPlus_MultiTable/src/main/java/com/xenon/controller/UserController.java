package com.xenon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xenon.entity.User;
import com.xenon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    UserMapper userMapper;

    @GetMapping("/")
    public List<User> getAllUsers()
    {
        return userMapper.getAllUsers();
    }

    @PostMapping("/")
    public String getPostData()
    {
        return "POST请求";
    }

    // 根据传入的uid查询用户
    @GetMapping("/find{uid}")
    public List<User> findByCond(@PathVariable String uid)
    {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_id", uid);
        return userMapper.selectList(userQueryWrapper);
    }

    // 分页查询
    @GetMapping("/findbypage")
    public IPage<User> findByPage()
    {
        // Page为一个范围，表示当前的位置和一页的量
        // 0表示页数，2表示每页多少个
        Page<User> userPage = new Page<>(0, 2);
        // IPage是分页后的结果，包含有许多参数返回给前端
        IPage<User> iPage = userMapper.selectPage(userPage, null);
        return iPage;
    }
}
