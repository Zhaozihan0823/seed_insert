package com.oracle.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	List list = new ArrayList();
	 
	Integer pageSize = 5;
	Integer currentPage = 1;
	Integer recordCount = 0;
	String url = null;
	
	

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public int getPageCount() {
		return this.recordCount%this.pageSize==0?this.recordCount/pageSize:this.recordCount/pageSize+1;
	}
	public PageInfo(HttpServletRequest request) {
		if(request.getParameter("currentPage")!=null) {
			this.currentPage = Integer.valueOf(request.getParameter("currentPage"));
		}
		this.url = request.getRequestURL().toString();
		request.setAttribute("pageInfo", this);
	}
	
	
}
