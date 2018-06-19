/** 
 * @Project     API4Diversion 
 * @File        ParameterException.java 
 * @Package     com.uubee.diversion.exception 
 * @Version     V1.0 
 * @Date        2017年3月31日 上午9:14:52 
 * @Author      maxm@uubee.com 
 */

package com.zcs.boot.server.exception;


import com.zcs.boot.server.enums.ResultCode;

/**
 * 
 * <p>@Title:ParameterException </p>
 * <p>@Description: 参数类异常</p>
 * <p>@Author zhengcs</p>
 * <p>@Date: 2017年8月3日 下午1:49:47</p>
 * <p>@Updaters: </p>
 */
public class ParameterException extends BusinessException {
      
	private static final long serialVersionUID = -2412593600288649352L;

	public ParameterException() {

		super(ResultCode.PARAM_ERROR);
	}
	
	public ParameterException(String message) {
		super(ResultCode.PARAM_ERROR.code,message);
	}
    
	public ParameterException(ResultCode resultCode) {
		super(resultCode.code, resultCode.msg);
	}
	
	public ParameterException(String code, String message) {
		super(code, message);
		
	}

	
}
