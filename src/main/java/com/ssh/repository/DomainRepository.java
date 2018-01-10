package com.ssh.repository;

import java.io.Serializable;
import java.util.List;

import com.ssh.entity.base.BaseReq;
import com.ssh.entity.base.BaseResp;

public interface DomainRepository<T,PK extends Serializable,REQ extends BaseReq,RESP extends BaseResp> {

	T load(PK id);
	T get(PK id);
	List<T> findAll();
	void persist(T entity);
	PK save(T entity);
	void saveOrUpdate(REQ req);
	void delete(PK id);
	void flush();
	RESP queryByCondition(REQ req);
}
