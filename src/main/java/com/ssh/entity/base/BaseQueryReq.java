package com.ssh.entity.base;

import java.io.Serializable;

/**
 * 查询请求基类
 * @author qiaoyk
 *
 */
public class BaseQueryReq extends BaseReq {
	private static final long serialVersionUID = 1L;
	private int pageNo;//当前页
	private int pageSize;//每页条数
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
