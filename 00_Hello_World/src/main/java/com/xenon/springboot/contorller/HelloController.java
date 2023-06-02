package com.xenon.springboot.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequestMapping("/hello")
    public String hello()
    {
        return "卷你妈呢卷你妈呢";
    }
}
