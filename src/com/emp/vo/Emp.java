package com.emp.vo;

import java.util.Date;

public class Emp {

	public int empno;
	public String ename;
	public String job;
	public int deptno;
	public double sal;
	public double comm;
	public int mgr;
	public Date hiredate;
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	public Emp() {
		super();
	}

	public Emp(int empno, String ename, String job, int deptno, double sal, double comm, int mgr, Date hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.deptno = deptno;
		this.sal = sal;
		this.comm = comm;
		this.mgr = mgr;
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "{empno=" + empno + ", ename=" + ename + ", job=" + job + ", deptno=" + deptno + ", sal=" + sal
				+ ", comm=" + comm + ", mgr=" + mgr + ", hiredate=" + hiredate + "}";
	}
	
	
	
}
