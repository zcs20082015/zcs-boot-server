/*
package com.zcs.boot.server.share.interceptor;

import com.billiontech.galaxy.mng.server.exception.BusinessException;
import com.billiontech.galaxy.mng.server.service.oper.IOperService;
import com.billiontech.galaxy.mng.server.share.util.SpringUtil;
import com.uubee.share.domain.OperatorInfo;
import com.uubee.share.util.FuncUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * @author: zhengcs@uubee.com
 * @Desc: 登录拦截器
 * @Date: 2018/6/14 12:27
 * @Modified:
 **//*

public class LoginInterceptor extends AbstractBaseInterceptor {

    //此处无法自动注入
    private IOperService operService= (IOperService) SpringUtil.getBean("operService");

    @Override
    public boolean customHandler(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String url=request.getRequestURI();

        Subject subject=SecurityUtils.getSubject();
        OperatorInfo oper=(OperatorInfo) subject.getPrincipals().getPrimaryPrincipal();
        info(getCorrelationID(request),oper.getOid_oper(),"进入"+url+"权限拦截器");
        //查询url对应的权限
        String right=operService.getTransCodeByUrl(getCorrelationID(request),url);
        //right="AES222";
        if(!FuncUtils.isNull(right)){
            subject.checkPermission(right);
        }

        return true;
    }
}
*/
