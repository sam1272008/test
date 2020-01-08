package com.emp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听器:
 * 监听的对象:  request   session   application
 * 
 * 	request
 * 		ServletRequestListener接口 ：监听request对象的创建和销毁
 * 		ServletRequestAttributeListener:监听request作用域中属性的添加，删除和修改
 * 	session
 * 		HttpSessionListener:session对象的创建和销毁
 * 		HttpSessionAttributeListener:监听session作用域中属性的添加，删除和修改
 * 	application:
 * 		ServletContextListener		application对象的创建和销毁
		ServletContextAttributeListener    监听application作用域中属性的添加，删除和修改
 * 
 *
 * 使用：
 * 	1.写一个java类，实现接口，实现接口的方法
 * 	2.web.xml中配监听器
 * 		<listener>
  			<listener-class>com.emp.listener.MyListener</listener-class>
  		</listener>
 * 
 * 案例:
 * 		统计在线人数
 */
public class MyListener implements HttpSessionListener,ServletContextListener {
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//获取当前人数
		ServletContext sc=se.getSession().getServletContext();
		int count = (int) sc.getAttribute("count");
		//人数+1
		count++;
		//设置人数
		sc.setAttribute("count", count);		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
			//获取当前人数
			ServletContext sc=se.getSession().getServletContext();
			int count = (int) sc.getAttribute("count");
			//人数-1
			count--;
			//设置人数
			sc.setAttribute("count", count);	
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//存在线人数=0
		sce.getServletContext().setAttribute("count", 0);
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub	
	}
	

	

}
