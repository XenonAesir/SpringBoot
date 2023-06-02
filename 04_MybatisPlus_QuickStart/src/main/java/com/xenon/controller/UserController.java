package com.xenon.controller;

import com.xenon.entity.User;
import com.xenon.mapper.UserMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> getAllUser()
    {
        // return userMapper.getAllUser();
        return userMapper.selectList(null);
    }


    @GetMapping("/{userID}")
    public List<User> getAllUser(@PathVariable Integer userID)
    {
        return userMapper.getUserByUserId(userID);
        // return userMapper.selectList();
    }

    @PutMapping("/")
    public int updateUser(User user)
    {
        return userMapper.updateUser(user);
    }

    @PostMapping("/")
    public int addUser(User user)
    {
        return userMapper.addUser(user);
    }

    @DeleteMapping("/{userID}")
    public int deleteUserByUserID(@PathVariable Integer userID)
    {
        return userMapper.deleteUser(userID);
    }
}