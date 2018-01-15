package com.ssh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ssh.controller.base.BaseController;
import com.ssh.entity.cache.TestCacheReq;
import com.ssh.entity.cache.TestCacheResp;
import com.ssh.entity.person.Person;
import com.ssh.entity.person.QueryPersonByConditionReq;
import com.ssh.entity.person.QueryPersonByConditionResp;
import com.ssh.service.PersonService;
import com.ssh.service.TestService;
import com.ssh.tools.session.UserSession;
import com.ssh.valid.ValidateParam;

@Controller
@RequestMapping(value="/main/")
public class MainController extends BaseController{

	@Autowired
	private TestService testService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "test",method = RequestMethod.POST)
	public String test(){
		return "test";
	}
	
	@RequestMapping(value = "springtest",method = RequestMethod.POST)
	public String springTest(){
		return testService.test();
	}
	
	@RequestMapping(value = "savePerson",method = RequestMethod.POST)
	@ResponseBody
	public String savePerson(){
		personService.savePerson();
		return "success";
	}
	
	@RequestMapping(value = "getPerson",method = RequestMethod.POST)
	@ResponseBody
	public String getPerson(){
		Person p = personService.getPerson(1L);
		return p.getUsername();
	}
	
	@RequestMapping(value = "queryPersonByCondition",method = RequestMethod.POST)
	public @ResponseBody QueryPersonByConditionResp queryByCondition(@RequestBody QueryPersonByConditionReq req){
		log.info("===============req:" + JSONObject.toJSONString(req));
		QueryPersonByConditionResp resp = personService.queryByCondition(req);
		log.info("===============resp:" + JSONObject.toJSONString(resp));
		return resp;
	}
	
	/**
	 * 测试缓存
	 * @param req
	 * @return
	 */
	@ValidateParam
	@RequestMapping(value = "testCache.do",method = RequestMethod.POST)
	public @ResponseBody TestCacheResp testCache(@RequestBody TestCacheReq req,HttpServletRequest request){
		TestCacheResp resp = new TestCacheResp();
		log.info("===============req:" + JSONObject.toJSONString(req));
		HttpSession session = request.getSession();
//		session.setAttribute("username", req.getUserName());
//		session.setAttribute("password", req.getPassword());
		UserSession.set("username", req.getUserName());
		UserSession.set("password", req.getPassword());
		session.setMaxInactiveInterval(20);
		String username = (String)UserSession.get("username");
		resp.setUsername(username);
		log.info("===============resp:" + JSONObject.toJSONString(resp));
		return resp;
	}
	
	@ValidateParam
	@RequestMapping(value = "testCache2.do",method = RequestMethod.POST)
	public @ResponseBody TestCacheResp testCache2(@RequestBody TestCacheReq req,HttpServletRequest request){
		TestCacheResp resp = new TestCacheResp();
		log.info("===============req:" + JSONObject.toJSONString(req));
//		request.getSession().setAttribute("username", req.getUserName());
//		request.getSession().setAttribute("password", req.getPassword());
		String username = (String)request.getSession().getAttribute("username");
		resp.setUsername(username);
		log.info("===============resp:" + JSONObject.toJSONString(resp));
		return resp;
	}
	
	
	public static void main(String[] args) {
		 
		//����Connection����
		         Connection con;
		        //����������
		         String driver = "com.mysql.jdbc.Driver";
		         //URLָ��Ҫ���ʵ����ݿ���mydata
		         String url = "jdbc:mysql://localhost:3306/ssh";
		         //MySQL����ʱ���û���
		         String user = "root";
		         //MySQL����ʱ������
		         String password = "root";
		         
		         try {
					//������������
					  Class.forName(driver);
					 //1.getConnection()����������MySQL���ݿ⣡��
					  con = DriverManager.getConnection(url,user,password);
					  System.out.println(con);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
