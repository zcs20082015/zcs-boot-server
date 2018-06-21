package com.zcs.boot.server.config;

import com.sun.org.apache.xerces.internal.xs.StringList;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.persistence.EntityManagerFactory;
import java.util.Arrays;

/**
 * @author: zhengcs
 * @Desc:
 * @Date: 2018/6/20 15:23
 * @Modified:
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean(){

        FilterRegistrationBean registrationBean=new FilterRegistrationBean();
        registrationBean.setFilter(new OpenEntityManagerInViewFilter());
        registrationBean.setName("openEntityManagerInViewFilter");

        registrationBean.setUrlPatterns(Arrays.asList("/*"));
        registrationBean.setOrder(Integer.MAX_VALUE);

        return registrationBean;
    }


    /*@Bean
    public SessionFactory sessionFactory(@Qualifier("entityManagerFactory") EntityManagerFactory emf){
        return emf.unwrap(SessionFactory.class);
    }*/
}
