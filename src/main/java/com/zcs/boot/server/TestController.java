package com.zcs.boot.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhengcs@uubee.com
 * @Desc:
 * @Date: 2018/6/19 17:19
 * @Modified:
 **/
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){

        System.out.println("ceshi ");
        return "test";
    }
}
