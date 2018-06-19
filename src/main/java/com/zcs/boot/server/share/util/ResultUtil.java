package com.zcs.boot.server.share.util;


import com.zcs.boot.server.domain.Result;
import com.zcs.boot.server.enums.ResultCode;

/**
 * @Author: zhengcs
 * @Desc:结果处理工具类
 * @Date: 2018/6/6 16:23
 * @Modified:
 **/
public class ResultUtil {

    /**
    *@Desc: 错误结果处理
    *@Author: zhengcs
    *@Date: 2018/6/6 18:24
    *@Modified: 
    */
    public static <T> Result<?> error(String msg){

        return error(ResultCode.FAIL.code,msg);
    }
    public static <T> Result<?> error(String code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        return result;
    }

    /**
    *@Desc: 成功结果处理
    *@Author: zhengcs
    *@Date: 2018/6/6 19:52
    *@Modified: 
    */
    public static <T> Result<?> success(T data){
        Result result=new Result();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        result.setData(data);
        return result;
    }


}
