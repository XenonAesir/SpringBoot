package com.xenon.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 标记为主程序类，这是一个SpringBoot应用
@SpringBootApplication
public class HelloApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HelloApplication.class, args);
    }
}
