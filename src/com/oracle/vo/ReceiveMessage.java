package com.oracle.vo;

import java.sql.Timestamp;

public class ReceiveMessage {
	int recieveId;
	int empId;
	int sendId;
	int messageState;
	Timestamp openDate;
	
	public Timestamp getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}
	public int getRecieveId() {
		return recieveId;
	}
	public void setRecieveId(int recieveId) {
		this.recieveId = recieveId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public int getMessageState() {
		return messageState;
	}
	public void setMessageState(int messageState) {
		this.messageState = messageState;
	}
	

}
