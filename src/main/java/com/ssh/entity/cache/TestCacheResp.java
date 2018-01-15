package com.ssh.entity.cache;

import com.ssh.entity.base.BaseResp;

/**
 * 测试缓存
 * @author qiaoyk
 *
 */
public class TestCacheResp extends BaseResp {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
