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
 * Filter:过滤器
 * 生命周期:服务器启动，过滤器对象就初始化，服务器关闭，过滤器对象销毁.当满足条件的请求被访问时，dofilter（）方法被调用
 * 
 * 使用：
 * 	1.写一个java类，实现Filter接口，实现Filter接口的方法
 * 	2.web.xml中配置filter
 * 		 <filter>
			  	<filter-name>filter1</filter-name>
			  	<filter-class>com.emp.filter.MyFilter</filter-class>
		  </filter>
		  <filter-mapping>
			  	<filter-name>filter1</filter-name>
			  	<url-pattern>/*</url-pattern>
		  </filter-mapping>
		  注意:
		  	<url-pattern>/*</url-pattern>    过滤所有请求
		  	<url-pattern>*.do</url-pattern>  过滤部分请求
		  	<url-pattern>/test</url-pattern>	过滤某个请求
	3.放行代码：
		chain.doFilter(request, response);
 * 
 * 
 * 案例:
 * 		过滤没有登录的访客
 * 
 */
public class MyFilter implements javax.servlet.Filter{

	

	@Override
	public void destroy() {
		System.out.println("MyFilter.destroy(过滤器，我被销毁了)");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter.doFilter(过滤器，执行过滤了)");
		//设置编码集
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = ((HttpServletRequest)request).getRequestURI();
		System.out.println(path);
		if( path.substring( path.lastIndexOf("/")+1).equals("login.jsp") ||
				path.substring(path.lastIndexOf("/")+1).equals("login")) {
			System.out.println("MyFilter.doFilter()::"+path+"不需要登录,被放行了");
			chain.doFilter(request, response);
		}else {
			//是否登录了
			HttpSession hs = ((HttpServletRequest)request).getSession();
			if( hs.getAttribute("user") == null ) {
				System.out.println("MyFilter.doFilter()::"+path+"没有登录，重定向到login。jsp了");
				((HttpServletResponse)response).sendRedirect("login.jsp");
			}else {
				//放行
				System.out.println("MyFilter.doFilter()::"+path+"已经登录了，放行了");
				chain.doFilter(request, response);
			}
		}		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter.init(我是过滤器，我被初始化了)");
		
	}

}
