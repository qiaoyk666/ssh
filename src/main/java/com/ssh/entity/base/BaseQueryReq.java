package com.ssh.entity.base;

import java.io.Serializable;

/**
 * ��ѯ�������
 * @author qiaoyk
 *
 */
public class BaseQueryReq extends BaseReq {
	private static final long serialVersionUID = 1L;
	private int pageNo;//��ǰҳ
	private int pageSize;//ÿҳ����
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
