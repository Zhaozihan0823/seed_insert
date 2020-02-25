package com.oracle.dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.vo.ReceiveMessage;

public class ReceiveMessageDao {
	
	//�ռ����������
	public void insert(ReceiveMessage message) {
		Dao.executeSql("insert into to_receivemessage values(null,?,?,1,null) ", 
				message.getSendId(), message.getEmpId());
	}
	
	//���ĳԱ���յ���������Ϣ
	public List<Object[]> getReceiveMessage(Integer receiveEmpId){
		return Dao.query("select receiveid,messagetitle,e.empname empName,opendate from\r\n" + 
				"to_receivemessage r inner join to_sendmessage s\r\n" + 
				"on r.sendid=s.sendid inner join tb_emp e on s.empid=e.empid\r\n" + 
				"where r.empid=? and r.messagestate=1 order by RECEIVEID desc", receiveEmpId);
	}
	
	//������Ϣ״̬
	public void updateState(Integer receiveId) {
		Dao.executeSql("update to_receivemessage set messagestate=2 where receiveid=?", receiveId);
	}
	
	//������Ϣ��ʱ��
	public void updateOpenTime(Integer receiveId) {
		Dao.executeSql("update to_receivemessage set opendate=now() where receiveid=?", receiveId);
	}
	
	//���ĳԱ���յ�����Ϣ
	public Object[] getReceiveMessageForId(Integer receiveId) {
		return Dao.queryOne("select receiveid,messagetitle,messagecontent,e.empname empName ,opendate from  \r\n" + 
				"to_receivemessage r inner join to_sendmessage s on r.sendid=s.sendid inner join tb_emp e on \r\n" + 
				"s.empid=e.empid where receiveid=? and r.messagestate=1  ", receiveId);
	}
}
