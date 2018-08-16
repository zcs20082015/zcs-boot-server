package com.zcs.boot.server.domain;

/**
 * @Author: zhengcs
 * @Desc:响应结果
 * @Date: 2018/6/6 16:33
 * @Modified:
 **/
public class Result<T> {

    private String code;
    private String msg;
    private boolean success=true;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
