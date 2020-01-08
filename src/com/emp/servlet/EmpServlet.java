package com.emp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.EmpDaoImpl;
import com.emp.vo.Emp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmpServlet extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("-----------emp servlet ʵ���Ѵ���--------------");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		EmpDaoImpl dao = new EmpDaoImpl();
		//ȡ--��ȡ����
		String type = request.getParameter("type");
		switch(type) {
		case "6":	//�޸�Ա����Ϣ
			//��ȡ����
			String ename1 = request.getParameter("ename");
			String job1 = request.getParameter("job");
			String mgr1 = request.getParameter("mgr");
			String hiredate1 = request.getParameter("hdate");
			String sal1 = request.getParameter("sal");
			String comm1 = request.getParameter("comm");
			String deptno1 = request.getParameter("deptno");
			String empno1 = request.getParameter("empno");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			//String ---��  Date
			Date d1 = null;
			try {
				d1 = sdf1.parse(hiredate1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//����service/dao
			Emp e2 = new Emp(Integer.parseInt(empno1), ename1, job1, Integer.parseInt(deptno1),Double.parseDouble(sal1),
					Double.parseDouble(comm1), Integer.parseInt(mgr1), d1);
			dao.update(e2);
			//��ת
			response.sendRedirect("emp?type=1");
			break;
		case "4":	//����EMPNO��ѯԱ����Ϣ
			String str_empno = request.getParameter("empno");
			Emp emp = dao.getByEmpno( Integer.parseInt(str_empno) );
			request.setAttribute("e", emp);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			break;	
		case "5":	//����ename��ѯԱ����Ϣ
			String ename2 = request.getParameter("ename");
			List<Emp> list1 = dao.getByEname(ename2);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw= response.getWriter();
			JSONArray ja = JSONArray.fromObject(list1);
			pw.write("aaa");
			//pw.print(JSONObject.fromObject(ja));
			//System.out.println(ja);
			//request.setAttribute("dd", list1);
			//request.getRequestDispatcher("query.jsp").forward(request, response);
			break;
		case "1":	//��ȡԱ���б�
			//��--����service/dao
			List<Emp> list = dao.getAll();
			//��--ҳ����ת========1.����ת��     2.�ض���
			request.setAttribute("data", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
			break;
		case "2":	//����empnoɾ��Ա����Ϣ
			//ȡ
			int empno = Integer.parseInt( request.getParameter("empno") );
			//��
			dao.delByEmpno(empno);	//���ݿ���ɾ��������
			//��---�ض���
			response.sendRedirect("emp?type=1");
			break;
		case "3":	//����һ��Ա������Ϣ
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			String mgr = request.getParameter("mgr");
			String hiredate = request.getParameter("hdate");
			String sal = request.getParameter("sal");
			String comm = request.getParameter("comm");
			String deptno = request.getParameter("deptno");
			System.out.println("EmpServlet.doGet():type=3:ename="+ename);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//String ---��  Date
			Date d = null;
			try {
				d = sdf.parse(hiredate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Emp e = new Emp(0, ename, job, Integer.parseInt(deptno),Double.parseDouble(sal),
					Double.parseDouble(comm), Integer.parseInt(mgr), d);
			dao.addone(e);
			//��
			response.sendRedirect("emp?type=1");
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	

}
