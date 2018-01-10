package com.ssh.service;

import com.ssh.entity.person.Person;
import com.ssh.entity.person.QueryPersonByConditionReq;
import com.ssh.entity.person.QueryPersonByConditionResp;

public interface PersonService {
	Long savePerson();
	Person getPerson(Long l);
	QueryPersonByConditionResp queryByCondition(QueryPersonByConditionReq req);
}
