package com.zcs.boot.server.share.interceptor;

import com.zcs.boot.server.AbstractBaseLogger;
import com.zcs.boot.server.enums.Globals;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author: zhengcs
 * @Desc:
 * @Date: 2018/6/7 16:03
 * @Modified:
 **/
public abstract class AbstractBaseInterceptor extends AbstractBaseLogger implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //执行具体拦截任务
        return customHandler(request,response,handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
    *@Desc: 自定义拦截处理
    *@Author: zhengcs
    *@Date: 2018/6/7 16:26
    *@Modified: 
    */
    public abstract boolean customHandler(HttpServletRequest request, HttpServletResponse response, Object handler);
    /**
    *@Desc: 初始化消息ID
    *@Author: zhengcs
    *@Date: 2018/6/7 16:12
    *@Modified: 
    */
    private void initCorrelationID(HttpServletRequest request){

    }

    protected String getCorrelationID(HttpServletRequest request){
        return request.getParameter(Globals.CORRELATIONID);
    }
}
