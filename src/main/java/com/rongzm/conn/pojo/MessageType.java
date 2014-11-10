package com.rongzm.conn.pojo;

import java.util.HashMap;
import java.util.Map;

public enum MessageType {
	TOP_WEBSITE(10),
	TOP_APP(11),
	TOAST(12),
	CUSTOM(13);
	
	private int value;
	private MessageType(int value){
		this.value = value;
	}
	
	public int value(){
		return value;
	}
	
	public static MessageType get(int value){
		return map.get(value);
	}
	
	static Map<Integer,MessageType> map;
	static{
		map = new HashMap<Integer,MessageType>();
		MessageType[] types = MessageType.values();
		for(MessageType type:types){
			map.put(type.value, type);
		}
	}
}
