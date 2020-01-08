package com.emp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.vo.Emp;

public class EmpDaoImpl extends BaseDao implements EmpDao{

	@Override
	public List<Emp> getAll() {
		List<Emp> list = new ArrayList<Emp>();
		//this.getConnection();
		ResultSet rs = this.executeQuery("select * from emp");
		try {
			while(rs.next()) {
				Emp e = new Emp();
				e.setComm( rs.getDouble("comm"));
				e.setDeptno( rs.getInt("deptno"));
				e.setEmpno( rs.getInt("empno"));
				e.setEname( rs.getString("ename"));
				e.setHiredate( rs.getDate("hiredate"));
				e.setJob( rs.getString("job"));
				e.setMgr( rs.getInt("mgr"));
				e.setSal( rs.getDouble("sal"));
				System.out.println(e);
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void delByEmpno(int empno) {
		this.executeUpdate("delete from emp where empno=?", empno);
		
	}

	@Override
	public void addone(Emp e) {
		String sql = "insert into emp values(null,?,?,?,?,?,?,?)";
		this.executeUpdate(sql, e.getEname(),e.getJob(),e.getMgr(),e.getHiredate(),e.getSal(),e.getComm(),e.getDeptno());
		
	}

	@Override
	public List<Emp> getByEname(String ename) {
		List<Emp> list = new ArrayList<Emp>();
		ResultSet rs = this.executeQuery("select * from emp where ename=?", ename);
		try {
			while(rs.next()) {
				Emp e = new Emp();
				e.setComm( rs.getDouble("comm"));
				e.setDeptno( rs.getInt("deptno"));
				e.setEmpno( rs.getInt("empno"));
				e.setEname( rs.getString("ename"));
				e.setHiredate( rs.getDate("hiredate"));
				e.setJob( rs.getString("job"));
				e.setMgr( rs.getInt("mgr"));
				e.setSal( rs.getDouble("sal"));
				
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public Emp getByEmpno(int empno) {
		Emp e = null;
		ResultSet rs = this.executeQuery("select * from emp where empno=?", empno);
		try {
			if(rs.next()) {
				e = new Emp();
				e.setComm( rs.getDouble("comm"));
				e.setDeptno( rs.getInt("deptno"));
				e.setEmpno( rs.getInt("empno"));
				e.setEname( rs.getString("ename"));
				e.setHiredate( rs.getDate("hiredate"));
				e.setJob( rs.getString("job"));
				e.setMgr( rs.getInt("mgr"));
				e.setSal( rs.getDouble("sal"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return e;
	}

	@Override
	public void update(Emp e) {
		String sql = "update emp set ename=?,job=?,mgr=?,sal=?,comm=?,hiredate=?,deptno=? where empno=?";
		this.executeUpdate(sql, e.getEname(),e.getJob(),e.getMgr(),
				e.getSal(),e.getComm(),e.getHiredate(),e.getDeptno(),e.getEmpno());
		
	}

}
