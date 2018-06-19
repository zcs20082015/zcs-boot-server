package com.zcs.boot.server.enums;

/**
 * 
 * <p>@Title:ResultCode </p>
 * <p>@Description: 错误码定义</p>
 * <p>@Author zhengcs</p>
 * <p>@Date: 2017年8月3日 下午1:39:03</p>
 * <p>@Updaters: </p>
 */
public enum ResultCode {

	/**************公共基础返回码*******************/
	SUCCESS("0000", "恭喜您，交易成功啦"),
	FAIL("9999", "系统异常"),
    CACHE_fAIL("9001","缓存操作异常"),
    REQUEST_NOT_WRAP("9002", "Request对象类别不为ParameterRequestWrapper"),

	/**************参数异常返回码*******************/
	PARAM_ERROR("1101", "请求参数错误"),
	PARAM_NULL("1102", "请求参数缺失"),

	;
	public final String code;
	public final String msg;
	
	ResultCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 *  @Description:   按code获取msg
	 *  @Author: MaFei
	 *  @Date: 2017/10/25 18:01
	 */
	public static String getMsgByCode(String code){

		for (ResultCode rc : ResultCode.values()){
			if (rc.getCode().equals(code)){
				return rc.getMsg();
			}
		}

		return "";
	}
}

