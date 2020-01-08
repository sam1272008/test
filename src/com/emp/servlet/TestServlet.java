package com.emp.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getSession().setAttribute("str", "session::str");
		//ServletContext  sc = request.getServletContext();
		//sc.setAttribute("str", "application::str");
		//request.setAttribute("str", "request::str");
		//request.getRequestDispatcher("test.jsp").forward(request, response);
		request.setAttribute("str", "123456");
		request.setAttribute("str", "666666");
		request.removeAttribute("str");
		System.out.println("TestServlet.doGet(servlet被调用了)");
		response.getWriter().write("拦截器学习");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}


}
