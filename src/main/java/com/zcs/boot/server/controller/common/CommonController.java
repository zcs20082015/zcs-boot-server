package com.zcs.boot.server.controller.common;

import com.zcs.boot.server.controller.BaseController;
import com.zcs.boot.server.enums.Globals;
import org.slf4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: zhengcs
 * @Desc: 通用接口
 * @Date: 2018/6/12 10:28
 * @Modified:
 **/
@Controller
@RequestMapping("common")
public class CommonController extends BaseController{

    @GetMapping("/go")
    public String goPage(String page){

        info(MDC.get(Globals.CORRELATIONID),page,"页面跳转接口");
        return page;
    }


}
