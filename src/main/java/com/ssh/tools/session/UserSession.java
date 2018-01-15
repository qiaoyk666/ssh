package com.ssh.tools.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 保存用户信息的session
 * @author qiaoyk
 *
 */
public class UserSession {
	/** * 保存变量的ThreadLocal，保持在同一线程中同步数据. */  
    private static final ThreadLocal SESSION_MAP = new ThreadLocal();  
  
    /** * 工具类的protected构造方法. */  
    protected UserSession() {  
    }
    
    /** 
     * 获得线程中保存的属性. 
     *  
     * @param attribute 
     *            属性名称 
     * @return 属性值 
     */  
    public static Object get(String attribute) {  
        Map map = (Map) SESSION_MAP.get();  
        System.out.println(map.toString());  
        return map.get(attribute);  
    } 
    
    /** 
     * 获得线程中保存的属性，使用指定类型进行转型. 
     *  
     * @param attribute 
     *            属性名称 
     * @param clazz 
     *            类型 
     * @param <T> 
     *            自动转型 
     * @return 属性值 
     */  
    public static <T> T get(String attribute, Class<T> clazz) {  
        return (T) get(attribute);  
    }  
  
    /** 
     * 设置制定属性名的值. 
     *  
     * @param attribute 
     *            属性名称 
     * @param value 
     *            属性值 
     */  
    public static void set(String attribute, Object value) {  
        Map map = (Map) SESSION_MAP.get();  
  
        if (map == null) {  
            map = new HashMap();  
            SESSION_MAP.set(map);  
        }  
  
        map.put(attribute, value);  
    }  
    
    public static void setSessionData(String attribute,Object value,HttpSession session){
    	if(session==null){
    		session = getSession();
    	}
    	session.setMaxInactiveInterval(20);
    	if(attribute!=null && value!=null){
    		session.setAttribute(attribute, value);
    	}
    }
    
    public static Object getSessionData(String attribute,HttpSession session){
    	if(session==null){
    		session = getSession();
    		System.out.println("session==============" + session);
    	}
    	if(attribute!=null){
    		return session.getAttribute(attribute);
    	}
    	return null;
    }
    
    public static HttpSession getSession(){
    	return getRequest().getSession(true);
    }
    
    public static HttpServletRequest getRequest(){
    	ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    	return requestAttributes==null ? null:requestAttributes.getRequest();
    }
}
