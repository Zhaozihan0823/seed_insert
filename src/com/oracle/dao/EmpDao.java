package com.oracle.dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.vo.Emp;

public class EmpDao {
	
	public Emp getEmp(String empno, String password) {
		return Dao.queryOne("select * from tb_emp where empno=? and password=md5(?)", Emp.class, empno, password);
	}
	
	public List<Emp> getAll(){
		return Dao.query("select * from tb_emp", Emp.class);
	}
}
