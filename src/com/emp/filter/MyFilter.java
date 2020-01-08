package com.emp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * Filter:������
 * ��������:����������������������ͳ�ʼ�����������رգ���������������.���������������󱻷���ʱ��dofilter��������������
 * 
 * ʹ�ã�
 * 	1.дһ��java�࣬ʵ��Filter�ӿڣ�ʵ��Filter�ӿڵķ���
 * 	2.web.xml������filter
 * 		 <filter>
			  	<filter-name>filter1</filter-name>
			  	<filter-class>com.emp.filter.MyFilter</filter-class>
		  </filter>
		  <filter-mapping>
			  	<filter-name>filter1</filter-name>
			  	<url-pattern>/*</url-pattern>
		  </filter-mapping>
		  ע��:
		  	<url-pattern>/*</url-pattern>    ������������
		  	<url-pattern>*.do</url-pattern>  ���˲�������
		  	<url-pattern>/test</url-pattern>	����ĳ������
	3.���д��룺
		chain.doFilter(request, response);
 * 
 * 
 * ����:
 * 		����û�е�¼�ķÿ�
 * 
 */
public class MyFilter implements javax.servlet.Filter{

	

	@Override
	public void destroy() {
		System.out.println("MyFilter.destroy(���������ұ�������)");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter.doFilter(��������ִ�й�����)");
		//���ñ��뼯
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = ((HttpServletRequest)request).getRequestURI();
		System.out.println(path);
		if( path.substring( path.lastIndexOf("/")+1).equals("login.jsp") ||
				path.substring(path.lastIndexOf("/")+1).equals("login")) {
			System.out.println("MyFilter.doFilter()::"+path+"����Ҫ��¼,��������");
			chain.doFilter(request, response);
		}else {
			//�Ƿ��¼��
			HttpSession hs = ((HttpServletRequest)request).getSession();
			if( hs.getAttribute("user") == null ) {
				System.out.println("MyFilter.doFilter()::"+path+"û�е�¼���ض���login��jsp��");
				((HttpServletResponse)response).sendRedirect("login.jsp");
			}else {
				//����
				System.out.println("MyFilter.doFilter()::"+path+"�Ѿ���¼�ˣ�������");
				chain.doFilter(request, response);
			}
		}		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter.init(���ǹ��������ұ���ʼ����)");
		
	}

}
