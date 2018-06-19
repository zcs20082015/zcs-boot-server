package com.zcs.boot.server.share.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: zhengcs@uubee.com
 * @Desc:
 * @Date: 2018/6/14 14:20
 * @Modified:
 **/
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext=null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(null==SpringUtil.applicationContext){
            SpringUtil.applicationContext=applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }
}
