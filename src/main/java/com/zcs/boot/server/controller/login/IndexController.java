package com.zcs.boot.server.controller.login;

import com.zcs.boot.server.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhengcs
 * @Desc:
 * @Date: 2018/6/14 12:24
 * @Modified:
 **/
@Controller
@RequestMapping
public class IndexController extends BaseController{

    @RequestMapping({"/","/index"})
    public String index(String correlationID){

       /* WebSubject subject=(WebSubject) SecurityUtils.getSubject();
        OperatorInfo oper=(OperatorInfo) subject.getPrincipals().getPrimaryPrincipal();
        info(correlationID,oper.getOid_oper(),"操作员登录成功");*/

        return "login/index";
    }

    @RequestMapping("/403")
    public String authorizedFail(String correlationID){

        /*WebSubject subject=(WebSubject) SecurityUtils.getSubject();
        OperatorInfo oper=(OperatorInfo) subject.getPrincipals().getPrimaryPrincipal();
        info(correlationID,oper.getOid_oper(),"操作员权限认证失败");*/

        return "403";
    }


}
