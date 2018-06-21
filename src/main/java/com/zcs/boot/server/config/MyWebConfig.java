package com.zcs.boot.server.config;

import com.zcs.boot.server.share.interceptor.LoggerInterceptor;
import com.zcs.boot.server.share.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: zhengcs
 * @Desc:
 * @Date: 2018/6/7 16:37
 * @Modified:
 **/
@Configuration
public class MyWebConfig extends WebMvcConfigurerAdapter{

    /**
    *@Desc: 添加自定义拦截器
    *@Author: zhengcs
    *@Date: 2018/6/7 16:53
    *@Modified: 
    */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login/login","/index","/error");
    }
}
