package com.zcs.boot.server.share.shiro;
import com.zcs.boot.server.entity.OperInfo;
import com.zcs.boot.server.enums.Globals;
import com.zcs.boot.server.service.oper.IOperService;
import com.zcs.boot.server.share.util.MD5Utils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
*@Desc:
*@Author: zhengcs@uubee.com
*@Date: 2018/6/20 13:59
*@Modified: 
*/
public class MyShiroRealm extends AuthorizingRealm{

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IOperService operService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String oidOper=(String) token.getPrincipal();
        String correlationID= MDC.get(Globals.CORRELATIONID);
        info(correlationID,oidOper,"进入操作员登录认证处理");
        OperInfo oper=operService.getOperInfo(correlationID,oidOper);
        if(oper.getStatus()!=1){
            throw new LockedAccountException();
        }
        //由于shiro自带的加密算法实现两次MD5的方式和我们自己的不一样，因此此处不使用shiro的加密算法，自行对用户传入的密码进行两次MD5加密
        char[] pwd=(char[]) token.getCredentials();
        pwd= MD5Utils.MD5Encrpytion(MD5Utils.MD5Encrpytion(String.valueOf(pwd))).toCharArray();
        System.out.println("String.valueOf(pwd):"+String.valueOf(pwd));
        ((UsernamePasswordToken) token).setPassword(pwd);
        SimpleAuthenticationInfo authenticationInfo =new SimpleAuthenticationInfo(oper,oper.getPassword(),getName());

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String correlationID= MDC.get(Globals.CORRELATIONID);
        OperInfo oper=(OperInfo) principalCollection.getPrimaryPrincipal();
        if(null==oper){
            throw new AuthorizationException();
        }
        info(correlationID,oper.getOidOper(),"进入操作员权限认证处理");

        //查询用户所有角色

        //查询用户所有权限
        List<String> rights=operService.getPermissionsByOper(correlationID,oper.getOidOper());

        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(rights);

        return authorizationInfo;
    }


    private void info(String correlationID, String key, String message) {
        logger.info("消息id [" + correlationID + "] key[" + key + "]"+ message);
    }
}
