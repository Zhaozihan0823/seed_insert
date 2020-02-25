package com.oracle.dao;

import java.util.Arrays;
import java.util.List;

import com.oracle.common.PageInfo;
import com.oracle.jdbc.util.Dao;
import com.oracle.vo.Company;

public class CompanyDao {
	
	public List<Company> getAllCompany(){
		return Dao.query("select * from tb_company", Company.class);
	}
	
	public void delete(String[] ids) {
		String str = Arrays.toString(ids);

        str = str.replace("[", "(");
        str = str.replace("]", ")");
		Dao.executeSql("delete from tb_company where companyId in"+ str);
	}
	
	public void getCompanyForPage(PageInfo pageInfo){
		@SuppressWarnings("rawtypes")
		List list = Dao.query("select * from tb_company limit ?,?", Company.class, 
				(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize(), pageInfo.getPageSize());
	
		pageInfo.setList(list);
		
		Long count = (Long)Dao.queryOne("select count(*) from tb_company")[0];
		pageInfo.setRecordCount(count.intValue());
	}
	
	public void insert(Company company) {
		Dao.executeSql("insert into tb_company values(null,?,?,?,?,now(),?)", company.getCompanyName(), 
				company.getLinkMan(), company.getTel(), company.getAddress(), company.getDescript());;
	}
	
	public Company getCompanyById(Integer companyId) {
		return Dao.queryOne("select * from tb_company where companyId=?", Company.class, companyId);
	}
}
