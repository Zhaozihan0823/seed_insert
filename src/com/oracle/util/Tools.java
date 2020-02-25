package com.oracle.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ������
 * @author Administrator
 *
 */
public class Tools {

	
	/*
	 * һ��java����ת����һ��json��ʽ���ַ���
	 */
	public static  String toJson(Object obj){
		ObjectMapper mapper=new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
		return "{}";		
	}
	
	public static Integer[] covert(String[] str) {
		if(str!=null) {
			Integer[] is = new Integer[str.length];
			for(int i=0;i<str.length;i++ ) {
				is[i] = Integer.valueOf(str[i]);
			}
			
			return is;
		}else {
			return new Integer[0];
		}
	}
}
