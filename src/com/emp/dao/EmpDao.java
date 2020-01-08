package com.emp.dao;

import java.util.List;

import com.emp.vo.Emp;

public interface EmpDao {

	List<Emp> getByEname(String ename);
	Emp getByEmpno(int empno);
	List<Emp> getAll();
	
	
	void delByEmpno(int empno);
	void addone(Emp e);
	void update(Emp e);
	
}
