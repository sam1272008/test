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
	
	

	/**��������
	 * 
	 * 1.������룺 response.setCharacterEncoding("UTF-8");
	 * 2.��get�������룺 String s = new String(uname.getBytes("ISO-8859-1"),"utf-8");
	 * 3.post�������룺 request.setCharacterEncoding("UTF-8");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * get����
	 * 		1.�޸�tomcat/conf/server.XML����<connector>������������
	 * 	    useBodyEncodingForURI='true' URIEncoding='UTF-8'
	 * 		2.ʹ��String���췽��
	 * 		String s = new String(uname.getBytes(), "ISO-8859-1");
	 * 		3.����request�����ȡ�������ַ�������
	 * 		request.setCharacterEncoding("UTF-8");
	 * post����
	 * 		1.����request�����ȡ�������ַ�������
	 * 		request.setCharacterEncoding("UTF-8");
	 * 		2.ʹ��String���췽��
	 * 		String s = new String(uname.getBytes("ISO-8859-1"),"utf-8");
	 * 
	 * servletʹ������:
	 * 1.����request��response������ַ�������
	 * 2.��ȡ����
	 * 3.����service
	 * 4.ҳ����ת
	 * 
	 * �����ת��  :request.getRequestDispatcher("index.jsp").forward(request, response);
	 * �ص㣺  һ������URL��ַ����,
	 *
	 * request������:�������һ���������ݹ��������
	 *       request.setAttribute("data", uname);
	 * session������:�������(һ�λỰ)�����ݹ�������
	 * 			seesion.setAttribute("data", uname);
	 *       
	 *       
	 *�ض���response.sendRedirect("index.jsp");
	 *�ص㣺��������URL��ַ����
	 * 
	 * Cookie����
	 * ����˲������洢�ڿͻ���
	*/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//ȡ
		String uname = request.getParameter("username");
		String s = new String(uname.getBytes("ISO-8859-1"),"utf-8");
		
		String passwd = request.getParameter("password"); 
		System.out.println("����username:"+uname);

		//��
		UserDao dao = new UserDaoImpl();
		User u = dao.getByUsername(uname);
		System.out.println(u);
		//��---1�ض���   2����ת��   3ֱ����Ӧ
		if( u == null || !u.getPassword().equals(passwd)) {
			//�û���������,�����������
			System.out.println("�û���������,�����������");
			request.setAttribute("error", "�û���/�������");
			request.getRequestDispatcher("login.jsp").forward(request, response); 
		}else {
			//�û���������ȷ
			System.out.println("�û���������ȷ");
			//-------------cookie---------------------
			//Cookie ck = new Cookie("username", "aaaaaa");	
			//ck.setMaxAge(3*24*3600);	
			//ck.setPath("/emp/test");			
			//response.addCookie(ck);
			//--------------session--------------------------
			//����/��ȡsession����
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
