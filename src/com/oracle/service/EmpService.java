package com.oracle.service;

import java.util.List;

import com.oracle.dao.EmpDao;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.Emp;

public class EmpService {

	EmpDao empDao = new EmpDao();
	
	@Transactional
	public Emp login(String empno, String password) {
		return empDao.getEmp(empno, password);
	}
	
	public List<Emp> getAll(){
		return empDao.getAll();
	}
}
