package com.oracle.vo;

public class Emp {
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empno=" + empno + ", empName=" + empName + ", password=" + password + "]";
	}
	int empid;
	String empno;
	String empName;
	String password;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
