package com.xenon.springboot.contorller;

import com.xenon.springboot.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/param")
public class ParamController
{
    // 以Get访问以下地址为例
    // localhost:8080/param/getXX?username=XXX&pwd=XXX
    // 这表示使用Get方法提交参数时是通过地址栏传入的，不安全且无法传输文件

    // 形参名称和传递的参数名称一致时可自动传入
    @GetMapping("/get01")
    public String get01(String username, String pwd)
    {
        return "用户名为：" + username + "，密码为：" + pwd;
    }

    // 形参名称和传递的参数名称不一致时需要使用@RequestParam注解重映射到形参
    // 这样使用后默认该参数不能为空，否则会400
    // 加入required = false后，来让其可以为空
    @GetMapping("/get02")
    public String get02(String username, @RequestParam(value = "pwd", required = false) String password)
    {
        return "用户名为：" + username + "，密码为：" + password;
    }


    // 以Post访问以下地址为例
    // localhost:8080/param/postXX
    // 通过Post方法发送的数据不会出现在地址栏，是请求体Body中的
    @PostMapping("/post01")
    public String post01(String username, String pwd)
    {
        return "用户名为：" + username + "，密码为：" + pwd;
    }

    // 可通过一个对象进行参数接受，会自动调用类中同名属性的set、get方法
    @PostMapping("/post02")
    public String post02(User user)
    {
        return "用户名为：" + user.getUsername() + "，密码为：" + user.getPwd();
    }

    // 通过JSON传递的参数需要在参数名称前使用@RequetBody注解
    @PostMapping("/post03")
    public String post03(@RequestBody User user)
    {
        return "用户名为：" + user.getUsername() + "，密码为：" + user.getPwd();
    }
}
