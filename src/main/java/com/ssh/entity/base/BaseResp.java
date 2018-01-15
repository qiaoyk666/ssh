package com.ssh.entity.base;

import java.io.Serializable;

public class BaseResp implements Serializable {

	private static final long serialVersionUID = 1L;

	private String resCode;
	private String resMesg;
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResMesg() {
		return resMesg;
	}
	public void setResMesg(String resMesg) {
		this.resMesg = resMesg;
	}
	
}
