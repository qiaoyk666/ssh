package com.ssh.repository;

import com.ssh.entity.base.BaseReq;
import com.ssh.entity.base.BaseResp;
import com.ssh.entity.person.Person;

//public interface PersonRepository extends DomainRepository<Person,Long,QueryPersonByConditionReq,QueryPersonByConditionResp>{
public interface PersonRepository extends DomainRepository<Person,Long,BaseReq,BaseResp>{
//	void saveOrUpdate(PersonUpdateReq req);
//	QueryPersonByConditionResp queryByCondition(QueryPersonByConditionReq req);
	
}
