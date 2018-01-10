package com.ssh.entity.person;

import java.util.List;

import com.ssh.entity.base.BaseResp;

public class QueryPersonByConditionResp extends BaseResp{
	private static final long serialVersionUID = 1L;
	private int totalNo;
	private List<QueryPersonByConditionInfo> rows;
	
	public int getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}
	public List<QueryPersonByConditionInfo> getRows() {
		return rows;
	}
	public void setRows(List<QueryPersonByConditionInfo> rows) {
		this.rows = rows;
	}
	
}
