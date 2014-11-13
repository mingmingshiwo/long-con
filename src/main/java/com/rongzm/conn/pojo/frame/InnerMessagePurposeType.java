package com.rongzm.conn.pojo.frame;

import java.util.HashMap;
import java.util.Map;

public enum InnerMessagePurposeType {
	APP(1),
	WEBSITE(2);
	
	int value;
	private InnerMessagePurposeType(int value){
		this.value = value;
	}
	
	public int value(){
		return value;
	}
	
	public static InnerMessagePurposeType get(int value){
		return map.get(value);
	}
	
	static Map<Integer,InnerMessagePurposeType> map;
	static{
		map = new HashMap<Integer,InnerMessagePurposeType>();
		InnerMessagePurposeType[] types = InnerMessagePurposeType.values();
		for(InnerMessagePurposeType type:types){
			map.put(type.value, type);
		}
	}
}
