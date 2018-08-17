package com.zcs.boot.server.service.oper;

import com.zcs.boot.server.AbstractBaseLogger;

/**
 * @author: zhengcs
 * @Desc:
 * @Date: 2018/6/11 21:29
 * @Modified:
 **/
public class BaseService extends AbstractBaseLogger {

    /**
    *@Desc: 判断返回码是不是成功
    *@Author: zhengcs
    *@Date: 2018/6/11 21:37
    *@Modified: 
    */
    protected boolean successCode(String code){

        if("000000".equals(code)||"0000".equals(code)){

            return true;
        }

        return false;
    }
}
