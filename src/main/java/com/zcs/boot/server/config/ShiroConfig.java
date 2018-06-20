package com.zcs.boot.server.config;

import com.zcs.boot.server.share.shiro.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: zhengcs@uubee.com
 * @Desc: shiro配置
 * @Date: 2018/6/8 16:35
 * @Modified:
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //拦截器
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<>();

        //过滤链定义，将/**放到最后面，否则出问题

        filterChainDefinitionMap.put("/**","authc");

        //退出过滤器
        filterChainDefinitionMap.put("/logout","logout");

        //设置登录页，登录成功页，未授权页
        shiroFilterFactoryBean.setLoginUrl("/login/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //设置拦截器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());

        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm=new MyShiroRealm();
        //myShiroRealm.setCredentialsMatcher(credentialsMatcher());
        return myShiroRealm;
    }

    /**
    *@Desc: 密码加密算法---两次md5
     * 由于此算法的两次加密逻辑和有贝的不一致，所以不使用此加密算法
    *@Author: zhengcs@uubee.com
    *@Date: 2018/6/12 18:07
    *@Modified: 
    */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2);
        return credentialsMatcher;
    }
}
