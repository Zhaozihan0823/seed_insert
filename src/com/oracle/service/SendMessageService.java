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
	
	//���ϱ�ʾ�����ע��
	@Transactional
	public void send(SendMessage message, Integer[] ids) {
		//���sendid
		Integer sendId = sendmessageDao.getMaxId();
		//�򷢼����в�����Ϣ
		message.setSendId(sendId);
		sendmessageDao.insert(message);
		//���ռ����в���n����¼
		for(Integer id:ids) {
			System.out.println(id);
			ReceiveMessage rm = new ReceiveMessage();
			rm.setEmpId(id);
			rm.setSendId(sendId);	//�����������
			receivemessageDao.insert(rm);
		}
	}
	
	public List<Object[]> getSendMessageForEmpId(Integer empId){
		List<Object[]> list_source = sendmessageDao.getSendMessageForEmpId(empId);
		List<Object[]> list_target = new ArrayList<Object[]>();
		System.out.println("�ϲ�ǰ��"+list_source);
		
		Object[] temp = null;	//��ʼֵΪ��
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
		
		//�������һ����¼
		if(temp!=null) {
			list_target.add(temp);
		}
		return list_target;
	}
	
	public Object[] getSendMessageForSendId(Integer sendId){
		List<Object[]> list_source = sendmessageDao.getSendMessageForSendId(sendId);
		
		Object[] temp = null;	//��ʼֵΪ��
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
