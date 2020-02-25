package com.oracle.vo;

import java.sql.Timestamp;

public class Company {
	Integer companyId;
	String companyName;
	String linkMan;
	String tel;
	String address;
	Timestamp createDate;
	String descript;
	
	public Company(Integer companyId, String companyName, String linkMan, String tel, String address,
			Timestamp createDate, String descript) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.linkMan = linkMan;
		this.tel = tel;
		this.address = address;
		this.createDate = createDate;
		this.descript = descript;
	}

	
	public Company() {
		super();
	}


	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan= linkMan;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}


	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", linkMan=" + linkMan + ", tel="
				+ tel + ", address=" + address + ", createDate=" + createDate + ", descript=" + descript + "]";
	}
	
	
}
