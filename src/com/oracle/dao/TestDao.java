package com.oracle.dao;

import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.service.SendMessageService;
import com.oracle.vo.SendMessage;

public class TestDao {

	public static void main(String[] args) {
		
		//���service
		SendMessageService sm = ServiceFactory.getObject(SendMessageService.class);
		
		SendMessage message = new SendMessage();
		message.setEmpId(3);
		message.setMessageTitle("�ú�ѧϰ");
		message.setMessageContent("��˯���������");
		message.setPriority(1);
		
		sm.send(message, new Integer[] {5,6,7,8});
		System.out.println("code");
	}
}
