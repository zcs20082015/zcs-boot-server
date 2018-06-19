package com.zcs.boot.server.exception;

import com.zcs.boot.server.AbstractBaseLogger;
import com.zcs.boot.server.domain.Result;
import com.zcs.boot.server.enums.Globals;
import com.zcs.boot.server.share.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zhengcs
 * @Desc:全局异常处理
 * @Date: 2018/6/6 15:26
 * @Modified:
 **/
@ControllerAdvice
public class GlobalExceptionHandler extends AbstractBaseLogger {

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result exceptionDeal(HttpServletRequest request, HandlerMethod handler, Exception e) throws Exception{
        String url=request.getRequestURI();
        String methodName=getMethodName(handler);
        String correlationID=request.getParameter(Globals.CORRELATIONID);
        error(correlationID,url,"请求处理异常",e.getMessage(),e);

        if(!isJsonView(handler)){
           throw e;
        }

        if(e instanceof BusinessException){
            BusinessException bx=(BusinessException) e;
                return ResultUtil.error(bx.getCode(),bx.getMsg());
        }

        return ResultUtil.error("异常");

    }
}
