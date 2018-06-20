package com.zcs.boot.server;

import com.alibaba.fastjson.JSON;
import com.zcs.boot.server.entity.OperInfo;
import com.zcs.boot.server.service.oper.IOperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhengcs@uubee.com
 * @Desc:
 * @Date: 2018/6/19 17:19
 * @Modified:
 **/
@RestController
public class TestController {

    @Autowired
    private IOperService operService;

    @RequestMapping("/mng")
    public String test(String correlationID){

        List<String> permissions=operService.getPermissionsByOper(correlationID,"zhengcs");

        return JSON.toJSONString(permissions);
    }
}
