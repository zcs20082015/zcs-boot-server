
package com.zcs.boot.server.exception;


import com.zcs.boot.server.enums.ResultCode;

/**
 * 
 * <p>@Title:BusinessException </p>
 * <p>@Description: 业务异常类</p>
 * <p>@Author zhengcs</p>
 * <p>@Date: 2017年8月3日 下午1:45:37</p>
 * <p>@Updaters: </p>
 */
public class BusinessException extends RuntimeException {
      
	private static final long serialVersionUID = 5256270592263608428L;

	private String code;
	private String msg;

	public BusinessException(){
	    super();
    }

    public BusinessException(String message) {    

	    super(message);
	    this.code= ResultCode.FAIL.code;
	    this.msg=msg;

    }    
    
    public BusinessException(String code, String message) {

        super(message);
        this.code=code;
        this.msg=msg;
    }
    
    public BusinessException(ResultCode resultCode) {

        super(resultCode.msg);
        this.code= resultCode.code;
        this.msg=resultCode.msg;
    }

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
}
