package com.ssh.entity.person;

import com.ssh.entity.base.BaseQueryReq;

public class QueryPersonByConditionReq extends BaseQueryReq {

	private static final long serialVersionUID = 1L;
	private String username;
	private String phone;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
