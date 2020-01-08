package com.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.UserDao;
import com.emp.dao.UserDaoImpl;
import com.emp.vo.User;

public class LoginServlet extends HttpServlet {
	
	

	/**中文乱码
	 * 
	 * 1.输出乱码： response.setCharacterEncoding("UTF-8");
	 * 2.，get请求乱码： String s = new String(uname.getBytes("ISO-8859-1"),"utf-8");
	 * 3.post请求乱码： request.setCharacterEncoding("UTF-8");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * get方法
	 * 		1.修改tomcat/conf/server.XML，在<connector>标记中添加属性
	 * 	    useBodyEncodingForURI='true' URIEncoding='UTF-8'
	 * 		2.使用String构造方法
	 * 		String s = new String(uname.getBytes(), "ISO-8859-1");
	 * 		3.设置request对象获取参数的字符集编码
	 * 		request.setCharacterEncoding("UTF-8");
	 * post方法
	 * 		1.设置request对象获取参数的字符集编码
	 * 		request.setCharacterEncoding("UTF-8");
	 * 		2.使用String构造方法
	 * 		String s = new String(uname.getBytes("ISO-8859-1"),"utf-8");
	 * 
	 * servlet使用流程:
	 * 1.设置request和response对象的字符集编码
	 * 2.获取参数
	 * 3.调用service
	 * 4.页面跳转
	 * 
	 * 请求的转发  :request.getRequestDispatcher("index.jsp").forward(request, response);
	 * 特点：  一次请求，URL地址不变,
	 *
	 * request作用域:解决的是一次请求数据共享的问题
	 *       request.setAttribute("data", uname);
	 * session作用域:多次请求(一次会话)的数据共享问题
	 * 			seesion.setAttribute("data", uname);
	 *       
	 *       
	 *重定向：response.sendRedirect("index.jsp");
	 *特点：两次请求，URL地址变了
	 * 
	 * Cookie技术
	 * 服务端产生，存储在客户端
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//取
		String uname = request.getParameter("username");
		String s = new String(uname.getBytes("ISO-8859-1"),"utf-8");
		
		String passwd = request.getParameter("password"); 
		System.out.println("参数username:"+uname);

		//调
		UserDao dao = new UserDaoImpl();
		User u = dao.getByUsername(uname);
		System.out.println(u);
		//跳---1重定向   2请求转发   3直接响应
		if( u == null || !u.getPassword().equals(passwd)) {
			//用户名不存在,或者密码错误
			System.out.println("用户名不存在,或者密码错误");
			request.setAttribute("error", "用户名/密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response); 
		}else {
			//用户名密码正确
			System.out.println("用户名密码正确");
			//-------------cookie---------------------
			//Cookie ck = new Cookie("username", "aaaaaa");	
			//ck.setMaxAge(3*24*3600);	
			//ck.setPath("/emp/test");			
			//response.addCookie(ck);
			//--------------session--------------------------
			//创建/获取session对象
			HttpSession hs = request.getSession();
			
			//System.out.println("JSEESIONID:"+hs.getId());
			//hs.setAttribute("data", new int[] {100,45,56});
			//Map<String,Integer> map = new HashMap<String,Integer>();
			//map.put("age", 24);
			//map.put("price",102);
			hs.setAttribute("user", u);
			response.sendRedirect("index.jsp");
			//request.setAttribute("uname", uname);
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}
