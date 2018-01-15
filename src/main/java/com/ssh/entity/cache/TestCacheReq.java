package com.ssh.entity.cache;

import com.ssh.entity.base.BaseReq;

/**
 * 测试缓存请求实体类
 * @author qiaoyk
 *
 */
public class TestCacheReq extends BaseReq {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
