package com.zcs.boot.server.share.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zhengcs
 * @Desc: 日志拦截器
 * @Date: 2018/6/7 16:27
 * @Modified:
 **/
public class LoggerInterceptor extends AbstractBaseInterceptor {

    @Override
    public boolean customHandler(HttpServletRequest request, HttpServletResponse response, Object handler) {

        info(getCorrelationID(request),request.getRequestURI(),"进入日志拦截器");
        return true;
    }
}
