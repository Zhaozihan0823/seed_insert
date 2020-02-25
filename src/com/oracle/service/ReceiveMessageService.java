package com.oracle.service;

import java.util.List;

import com.oracle.dao.ReceiveMessageDao;
import com.oracle.jdbc.util.Transactional;

public class ReceiveMessageService {
		
	ReceiveMessageDao rmd = new ReceiveMessageDao();
		@Transactional
		public List<Object[]> getReceiveMessage(Integer receiveId){
			return rmd.getReceiveMessage(receiveId);
		}
	
		@Transactional
		public void removeReceiveMessage(Integer receiveId) {
			rmd.updateState(receiveId);
		}
		
		@Transactional
		public void updateOpenDate(Integer receiveId) {
			rmd.updateOpenTime(receiveId);
		}
		
		@Transactional
		public Object[] getReceiveMessageForId(Integer receiveId) {
			return rmd.getReceiveMessageForId(receiveId);
		}
		
		
}
