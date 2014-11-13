package com.rongzm.conn.pojo.frame;

import java.util.HashMap;
import java.util.Map;

public enum MessageSendType {
	SINGLE(1),
	GROUP(2),
	BROADCAST(3);
	
	private int value;
	private MessageSendType(int value){
		this.value = value;
	}
	
	public int value(){
		return value;
	}
	
	public static MessageSendType get(int value){
		return map.get(value);
	}
	
	static Map<Integer,MessageSendType> map;
	static{
		map = new HashMap<Integer,MessageSendType>();
		MessageSendType[] types = MessageSendType.values();
		for(MessageSendType type:types){
			map.put(type.value, type);
		}
	}
}
