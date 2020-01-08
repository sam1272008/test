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
 * ������:
 * �����Ķ���:  request   session   application
 * 
 * 	request
 * 		ServletRequestListener�ӿ� ������request����Ĵ���������
 * 		ServletRequestAttributeListener:����request�����������Ե���ӣ�ɾ�����޸�
 * 	session
 * 		HttpSessionListener:session����Ĵ���������
 * 		HttpSessionAttributeListener:����session�����������Ե���ӣ�ɾ�����޸�
 * 	application:
 * 		ServletContextListener		application����Ĵ���������
		ServletContextAttributeListener    ����application�����������Ե���ӣ�ɾ�����޸�
 * 
 *
 * ʹ�ã�
 * 	1.дһ��java�࣬ʵ�ֽӿڣ�ʵ�ֽӿڵķ���
 * 	2.web.xml���������
 * 		<listener>
  			<listener-class>com.emp.listener.MyListener</listener-class>
  		</listener>
 * 
 * ����:
 * 		ͳ����������
 */
public class MyListener implements HttpSessionListener,ServletContextListener {
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//��ȡ��ǰ����
		ServletContext sc=se.getSession().getServletContext();
		int count = (int) sc.getAttribute("count");
		//����+1
		count++;
		//��������
		sc.setAttribute("count", count);		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
			//��ȡ��ǰ����
			ServletContext sc=se.getSession().getServletContext();
			int count = (int) sc.getAttribute("count");
			//����-1
			count--;
			//��������
			sc.setAttribute("count", count);	
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//����������=0
		sce.getServletContext().setAttribute("count", 0);
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub	
	}
	

	

}
