package com.oracle.service;

import java.util.ArrayList;
import java.util.List;

import com.oracle.dao.ReceiveMessageDao;
import com.oracle.dao.SendMessageDao;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.ReceiveMessage;
import com.oracle.vo.SendMessage;

public class SendMessageService {

	SendMessageDao sendmessageDao = new SendMessageDao();
	ReceiveMessageDao receivemessageDao = new ReceiveMessageDao();
	
	//加上表示事务的注解
	@Transactional
	public void send(SendMessage message, Integer[] ids) {
		//获得sendid
		Integer sendId = sendmessageDao.getMaxId();
		//向发件箱中插入消息
		message.setSendId(sendId);
		sendmessageDao.insert(message);
		//向收件箱中插入n条记录
		for(Integer id:ids) {
			System.out.println(id);
			ReceiveMessage rm = new ReceiveMessage();
			rm.setEmpId(id);
			rm.setSendId(sendId);	//获得自增主键
			receivemessageDao.insert(rm);
		}
	}
	
	public List<Object[]> getSendMessageForEmpId(Integer empId){
		List<Object[]> list_source = sendmessageDao.getSendMessageForEmpId(empId);
		List<Object[]> list_target = new ArrayList<Object[]>();
		System.out.println("合并前："+list_source);
		
		Object[] temp = null;	//初始值为空
		for(Object[] obj:list_source) {
			if(temp==null) {
				temp=obj;
			}else if(temp[0].equals(obj[0])) {
				temp[3] = temp[3]+","+obj[3];
			}else {
				list_target.add(temp);
				temp=obj;
			}
		}
		
		//增加最后一条记录
		if(temp!=null) {
			list_target.add(temp);
		}
		return list_target;
	}
	
	public Object[] getSendMessageForSendId(Integer sendId){
		List<Object[]> list_source = sendmessageDao.getSendMessageForSendId(sendId);
		
		Object[] temp = null;	//初始值为空
		for(Object[] obj:list_source) {
			if(temp==null) {
				temp=obj;
			}else {
				temp[3] = temp[3]+","+obj[3];
			}
		}
		
			return temp;
	}
	
	@Transactional
	public void removeSenMessage(Integer sendId) {
		sendmessageDao.updateMessageStste(sendId);
	}
}
