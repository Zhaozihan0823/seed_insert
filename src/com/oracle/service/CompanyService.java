package com.oracle.service;

import java.util.List;

import com.oracle.common.PageInfo;
import com.oracle.dao.CompanyDao;
import com.oracle.vo.Company;

public class CompanyService {
	CompanyDao comdao = new CompanyDao();
	
	public List<Company> getAllCompany(){
		return comdao.getAllCompany();
	}
	
	public void getCompanyForPage(PageInfo pageInfo) {
		comdao.getCompanyForPage(pageInfo);
	}
	
	public void delete(String[] ids) {
		comdao.delete(ids);
	}
	
	public void insert(Company company) {
		comdao.insert(company);
	}
	
	public Company getCompanyById(Integer companyId) {
		return comdao.getCompanyById(companyId);
	}
}
