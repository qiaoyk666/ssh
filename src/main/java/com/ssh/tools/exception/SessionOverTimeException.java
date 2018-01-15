package com.ssh.tools.exception;

/**
 * session超时异常
 * @author qiaoyk
 *
 */
public class SessionOverTimeException extends Exception {
	private static final long serialVersionUID = 1L;
	//错误代码
	private String errorCode;
	//异常信息
	private String message;
	
	public SessionOverTimeException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
