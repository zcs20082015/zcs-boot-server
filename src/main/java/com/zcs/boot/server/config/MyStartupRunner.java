package com.zcs.boot.server.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: zhengcs
 * @Desc: 启动执行
 * @Date: 2018/6/7 17:01
 * @Modified:
 **/
@Component
@Order(1)
public class MyStartupRunner implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println("测试测试");
    }
}
