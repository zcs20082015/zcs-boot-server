package com.zcs.boot.server.controller.login;

import com.zcs.boot.server.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zhengcs@uubee.com
 * @Desc: 登录接口
 * @Date: 2018/6/12 11:24
 * @Modified:
 **/
@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

    /**
    *@Desc: 登录
    *@Author: zhengcs@uubee.com
    *@Date: 2018/6/12 11:26
    *@Modified: 
    */
    @RequestMapping("/login")
    public String login(String correlationID,String username, HttpServletRequest request, Model model){
        //认证结果
        String exceptionMsg = (String) request.getAttribute("shiroLoginFailure");

        info(correlationID,username,"进入用户登录认证处理接口,exceptionMsg="+exceptionMsg);

        String msg="";
        if(null!=exceptionMsg){
            /*if (UnknownAccountException.class.getName().equals(exceptionMsg)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionMsg)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if (LockedAccountException.class.getName().equals(exceptionMsg)) {
                System.out.println("LockedAccountException -- > 账户状态异常");
                msg = "LockedAccountException -- > 账户状态异常";
            } else if ("kaptchaValidateFailed".equals(exceptionMsg)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exceptionMsg;
                System.out.println("else -- >" + exceptionMsg);
            }*/
        }

        model.addAttribute("msg",msg);
        return "login/login";
    }



}
