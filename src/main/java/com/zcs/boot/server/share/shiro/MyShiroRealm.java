/*
package com.zcs.boot.server.share.shiro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

*/
/**
 * @author: zhengcs
 * @Desc:
 * @Date: 2018/6/8 17:15
 * @Modified:
 **//*

public class MyShiroRealm extends AuthorizingRealm{

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IOperService operService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String oidOper=(String) token.getPrincipal();
        String correlationID= MDC.get(Globals.CORRELATIONID);
        info(correlationID,oidOper,"进入操作员登录认证处理");
        OperatorInfo oper=operService.getOperInfo(correlationID,oidOper);
        if(!"3".equals(oper.getStat_oper())){
            throw new LockedAccountException();
        }
        //由于shiro自带的加密算法实现两次MD5的方式和我们自己的不一样，因此此处不使用shiro的加密算法，自行对用户传入的密码进行两次MD5加密
        char[] pwd=(char[]) token.getCredentials();
        pwd=MD5Utils.MD5Encrpytion(MD5Utils.MD5Encrpytion(String.valueOf(pwd))).toCharArray();
        System.out.println("String.valueOf(pwd):"+String.valueOf(pwd));
        ((UsernamePasswordToken) token).setPassword(pwd);
        SimpleAuthenticationInfo authenticationInfo =new SimpleAuthenticationInfo(oper,oper.getPwd_oper(),getName());

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String correlationID= MDC.get(Globals.CORRELATIONID);
        OperatorInfo oper=(OperatorInfo) principalCollection.getPrimaryPrincipal();
        if(null==oper){
            throw new AuthorizationException();
        }
        info(correlationID,oper.getOid_oper(),"进入操作员权限认证处理");

        //查询用户所有角色

        //查询用户所有权限
        List<String> rights=operService.getTransCodeByOper(correlationID,oper.getOid_oper());

        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(rights);

        return authorizationInfo;
    }


    private void info(String correlationID, String key, String message) {
        logger.info("消息id [" + correlationID + "] key[" + key + "]"+ message);
    }
}*/
