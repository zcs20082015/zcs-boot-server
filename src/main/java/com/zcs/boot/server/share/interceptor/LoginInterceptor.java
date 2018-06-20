package com.zcs.boot.server.share.interceptor;

import com.zcs.boot.server.entity.OperInfo;
import com.zcs.boot.server.service.oper.IOperService;
import com.zcs.boot.server.share.util.SpringUtil;
import com.zcs.boot.server.share.util.UtilTool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zhengcs
 * @Desc: 登录拦截器
 * @Date: 2018/6/14 12:27
 * @Modified:
 **/
public class LoginInterceptor extends AbstractBaseInterceptor {

    /**
     * 此处无法自动注入
     */
    private IOperService operService= (IOperService) SpringUtil.getBean("operService");

    @Override
    public boolean customHandler(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String url=request.getRequestURI();

        Subject subject=SecurityUtils.getSubject();
        OperInfo oper=(OperInfo) subject.getPrincipals().getPrimaryPrincipal();
        info(getCorrelationID(request),oper.getOidOper(),"进入"+url+"权限拦截器");
        //查询url对应的权限
        String right=operService.getMenuCodeByUrl(getCorrelationID(request),url);
        //right="AES222";
        if(!UtilTool.isNull(right)){
            subject.checkPermission(right);
        }

        return true;
    }
}
