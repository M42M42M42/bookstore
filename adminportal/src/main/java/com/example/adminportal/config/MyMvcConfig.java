package com.example.adminportal.config;

import com.example.adminportal.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author: XLee
 * Date: 2020/11/11 20:27
 * Description:
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //将登陆拦截器配置到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对所有的请求都进行拦截
        registry.addInterceptor((new LoginHandlerInterceptor()))
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/css/**", "/js/**");


    }

    //配置视图跳转
    /*
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName();

    }*/
}
