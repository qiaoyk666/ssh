package com.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.entity.person.Person;
import com.ssh.entity.person.QueryPersonByConditionReq;
import com.ssh.entity.person.QueryPersonByConditionResp;
import com.ssh.repository.PersonRepository;
import com.ssh.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Long savePerson() {
		Person person = new Person();
		person.setUsername("ssh");
		person.setPhone("18273273772");
		person.setAddress("北京市海淀区");
		person.setRemark(" remark ");
		return personRepository.save(person);
	}

	public Person getPerson(Long l) {
		return personRepository.load(l);
	}
	
	public QueryPersonByConditionResp queryByCondition(QueryPersonByConditionReq req){
		if(req.getPageNo()<=0){
			req.setPageNo(1);
		}
		if(req.getPageSize()<=0){
			req.setPageSize(20);
		}
		QueryPersonByConditionResp resp = new QueryPersonByConditionResp();
		resp = (QueryPersonByConditionResp)personRepository.queryByCondition(req);
		return resp;
	}

}
