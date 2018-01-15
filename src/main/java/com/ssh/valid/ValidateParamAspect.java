package com.ssh.valid;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.ssh.entity.base.BaseResp;
import com.ssh.tools.exception.SessionOverTimeException;
import com.ssh.tools.session.UserSession;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

@Aspect
@Component
public class ValidateParamAspect {
	
	//这里是关键点，把切面的连接点放在了我们的注解上
	@Pointcut("@annotation(com.ssh.valid.ValidateParam)")
	public void controllAspect(){

	}
	
	@Before("controllAspect()")
	public BaseResp beforeMethod(JoinPoint joinPoint) throws SessionOverTimeException {
		BaseResp baseResp = new BaseResp();
		String classType = joinPoint.getTarget().getClass().getName();
		try {
			Class<?> clazz = Class.forName(classType);
			String clazzName = clazz.getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] args = joinPoint.getArgs();
			Map<String,Object> nameAndArgs = getFieldsName(this.getClass(),clazzName,methodName,args);
//			String userName = (String)nameAndArgs.get("userName");
//			String password = (String)nameAndArgs.get("password");
			
			Object userName = UserSession.getSessionData("userName", null);
			System.out.println("userName session = " + userName);
			if(userName==null || "".equals(userName)){
				baseResp.setResCode("2");
				baseResp.setResMesg("session超时！");
				throw new SessionOverTimeException("2","session超时！！");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("baseResp.resMsg---" + baseResp.getResMesg());
		return baseResp;
	}

	private Map<String,Object> getFieldsName(Class cls,String clazzName,String methodName,Object[] args) throws NotFoundException{
		Map<String,Object> map = new HashMap<String,Object>();
		ClassPool pool = ClassPool.getDefault();
		ClassClassPath classPath = new ClassClassPath(cls);
		pool.insertClassPath(classPath);
		
		CtClass cc = pool.get(clazzName);
		cc.getFields();
		for(int i = 0; i<cc.getFields().length;i++){
			Field[] fieldses = args[i].getClass().getDeclaredFields();
			for(int j=0;j<fieldses.length;j++){
				fieldses[j].setAccessible(true);
				Object obj;
				try {
					obj = fieldses[j].get(args[i]);
					map.put(fieldses[j].getName(), obj);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}

	
	@After("controllAspect()")
	public void afterMethod(JoinPoint joinPoint){
		System.out.println("验证注解切面，在方法执行后执行===after method===");
	}
}
