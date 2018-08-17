package com.zcs.boot.server;

import com.alibaba.fastjson.JSON;
import com.zcs.boot.server.share.util.UtilTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * @ClassName: AbstractBaseLogger
 * @Description: 抽象日志基础类
 * @author zhengcs
 * @date 2017/6/8
*/
public abstract class AbstractBaseLogger {


    protected final Logger logger = LoggerFactory.getLogger(super.getClass());

    protected void info(String correlationID, String key, String message) {
        logger.info("消息id [" + correlationID + "] key[" + key + "]"+ message);
    }

    protected void info(String correlationID, String message) {
        info(correlationID, "", message);
    }

    protected void info(String correlationID,String key,String msg,Object info){
    	logger.info("消息id [" + correlationID + "] key[" + key + "]"+ msg+JSON.toJSONString(info));
	}
    protected void error(String correlationID, String key, String message, String error, Throwable e) {
        logger.error("消息id [" + correlationID + "] key[" + key + "] error: " + error
                + "; message :" + message, e);
    }

    protected void error(String correlationID, String key, String message, String error) {
        error(correlationID, key, message, error, null);
    }

    protected void error(String correlationID, String message, String error, Throwable e) {
        error(correlationID, "", message, error, e);
    }

    /**
    *@Desc:判断是否是json请求
    *@Author: zhengcs
    *@Date: 2018/6/7 9:51
    *@Modified: 
    */
    protected boolean isJsonView(HandlerMethod handler) {
        if (null != handler){
            RestController restController = ((HandlerMethod) handler).getBeanType().getAnnotation(RestController.class);
            if (null != restController) {
                return true;
            }
            ResponseBody responseBody = ((HandlerMethod) handler).getMethod().getAnnotation(ResponseBody.class);
            if (null != responseBody) {
                return true;
            }
            return false;
        }
        return false;

    }

    /**
    *@Desc: 获取请求方法名称
    *@Author: zhengcs
    *@Date: 2018/6/7 9:52
    *@Modified: 
    */
    protected String getMethodName(HandlerMethod handler) {
        if (null != handler) {
            Method method = handler.getMethod();
            return method.getName();
        }
        return "";
    }

    /**
    *@Desc: 判断非空
    *@Author: zhengcs
    *@Date: 2018/6/21 10:00
    *@Modified: 
    */
    protected boolean isNull(String str){

        return UtilTool.isNull(str);
    }
}
