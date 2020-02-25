package com.oracle.dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.vo.ReceiveMessage;

public class ReceiveMessageDao {
	
	//收件箱插入数据
	public void insert(ReceiveMessage message) {
		Dao.executeSql("insert into to_receivemessage values(null,?,?,1,null) ", 
				message.getSendId(), message.getEmpId());
	}
	
	//获得某员工收到的所有消息
	public List<Object[]> getReceiveMessage(Integer receiveEmpId){
		return Dao.query("select receiveid,messagetitle,e.empname empName,opendate from\r\n" + 
				"to_receivemessage r inner join to_sendmessage s\r\n" + 
				"on r.sendid=s.sendid inner join tb_emp e on s.empid=e.empid\r\n" + 
				"where r.empid=? and r.messagestate=1 order by RECEIVEID desc", receiveEmpId);
	}
	
	//更新消息状态
	public void updateState(Integer receiveId) {
		Dao.executeSql("update to_receivemessage set messagestate=2 where receiveid=?", receiveId);
	}
	
	//更新消息打开时间
	public void updateOpenTime(Integer receiveId) {
		Dao.executeSql("update to_receivemessage set opendate=now() where receiveid=?", receiveId);
	}
	
	//获得某员工收到的消息
	public Object[] getReceiveMessageForId(Integer receiveId) {
		return Dao.queryOne("select receiveid,messagetitle,messagecontent,e.empname empName ,opendate from  \r\n" + 
				"to_receivemessage r inner join to_sendmessage s on r.sendid=s.sendid inner join tb_emp e on \r\n" + 
				"s.empid=e.empid where receiveid=? and r.messagestate=1  ", receiveId);
	}
}
