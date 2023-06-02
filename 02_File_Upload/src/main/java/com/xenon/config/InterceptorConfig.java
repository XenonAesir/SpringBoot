package com.xenon.config;

import com.xenon.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // 注册拦截器
        // 可选参数.addPathPatterns()设置需要对哪些路径生效
        // 可选参数.excludePathPatterns()设置需要对哪些路径不生效
        // 不设置则对所有路径都生效
        registry.addInterceptor(new LoginInterceptor());
    }
}
