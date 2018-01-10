package com.ssh.repository.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.entity.base.BaseReq;
import com.ssh.entity.base.BaseResp;
import com.ssh.entity.person.Person;
import com.ssh.entity.person.PersonUpdateReq;
import com.ssh.entity.person.QueryPersonByConditionInfo;
import com.ssh.entity.person.QueryPersonByConditionReq;
import com.ssh.entity.person.QueryPersonByConditionResp;
import com.ssh.repository.PersonRepository;

@Repository  
public class PersonRepositoryImpl implements PersonRepository {

	@Autowired 
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){ 
		return this.sessionFactory.openSession();
	}
	public Person load(Long id) {
		return (Person)getCurrentSession().load(Person.class, id);
	}

	public Person get(Long id) {
		return (Person)getCurrentSession().load(Person.class, id);
	}

	public List<Person> findAll() {
//		return getCurrentSession().
		
		return null;
	}

	public void persist(Person entity) {
		getCurrentSession().persist(entity);
	}

	public Long save(Person entity) {
		return (Long)getCurrentSession().save(entity);
	}

	public void saveOrUpdate(PersonUpdateReq req) {
		getCurrentSession().saveOrUpdate(req);
	}

	public void delete(Long id) {
		Person person = load(id);
		getCurrentSession().delete(person);
	}

	public void flush() {
		getCurrentSession().flush();
	}
	/*public QueryPersonByConditionResp queryByCondition(QueryPersonByConditionReq req) {
		QueryPersonByConditionResp resp = new QueryPersonByConditionResp();
		StringBuilder sb = new StringBuilder("from Person where 1=1 ");
		if(req!=null && req.getUsername()!=null){
			sb.append("AND username = '" + req.getUsername() + "' ");
		}
		if(req!=null && req.getPhone()!=null){
			sb.append("AND phone = '" + req.getPhone() + "' ");
		}
		
		@SuppressWarnings("unchecked")
		Query q = getCurrentSession().createQuery(sb.toString());
		q.setFirstResult((req.getPageNo()-1)*req.getPageSize());
		q.setMaxResults(req.getPageSize());
		List<QueryPersonByConditionInfo> rows = q.list();
		resp.setRows(rows);
		resp.setTotalNo(queryCount(req));
		return resp;
	}*/
	
	public int queryCount(QueryPersonByConditionReq req){
		StringBuilder sb = new StringBuilder("from Person where 1=1 ");
		if(req!=null && req.getUsername()!=null){
			sb.append("AND username = '" + req.getUsername() + "' ");
		}
		if(req!=null && req.getPhone()!=null){
			sb.append("AND phone = '" + req.getPhone() + "' ");
		}
		@SuppressWarnings("unchecked")
		Query q = getCurrentSession().createQuery(sb.toString());
		return q.list().size();
	}
	public void saveOrUpdate(BaseReq req) {
		// TODO Auto-generated method stub
		
	}
	public BaseResp queryByCondition(BaseReq req) {
		// TODO Auto-generated method stub
		return null;
	}
}
