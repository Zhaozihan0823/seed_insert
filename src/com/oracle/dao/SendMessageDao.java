package com.oracle.dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.vo.SendMessage;

public class SendMessageDao {
	
	public void insert(SendMessage send) {
		Dao.executeSql("insert into to_sendmessage values(?,?,?,?,now(),?,1)", send.getSendId(),
				send.getEmpId(), send.getMessageTitle(), send.getMessageContent(), send.getPriority());
	}
	
	public Integer getMaxId() {
		return ((Long)Dao.queryOne("select max(sendId)+1 from to_sendmessage")[0]).intValue();
	}
	
	//发件箱列表
	public List<Object[]> getSendMessageForEmpId(Integer empId){
		return Dao.query("select s.sendid sendid,messagetitle, createdate,empname from to_sendmessage s inner join to_receivemessage r\r\n" + 
				"on s.sendid=r.sendid inner join tb_emp e on r.empid=e.empid \r\n" + 
				"where s.empid=? and s.messagestate=1 order by createDate desc", empId);
	}
	
	public List<Object[]> getSendMessageForSendId(Integer sendId){
		return Dao.query("select s.sendid sendid,messagetitle, createdate,e.empname empname,messagecontent,se.empname sender \r\n" + 
				"from to_sendmessage s inner join to_receivemessage r on s.sendid=r.sendid inner join tb_emp e \r\n" + 
				"on r.empid=e.empid inner join tb_emp se on s.empid=se.empid\r\n" + 
				"where s.sendid=? and s.messagestate=1 order by createDate desc", sendId);
	}
	
	public void updateMessageStste(Integer sendId) {
		Dao.executeSql("update to_sendmessage set messagestate=2 where sendid=?", sendId);
	}
}
