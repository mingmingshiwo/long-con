package com.rongzm.conn.pojo.frame;

import java.util.HashMap;
import java.util.Map;

public enum FrameType {
	PING(1),
	PONG(2),
	REGIST(3),
	LOGIN(4),
	//message
	INNER(5),
	CUSTOM(6);
	
	int value;
	private FrameType(int value){
		this.value = value;
	}
	
	public int value(){
		return value;
	}
	
	public static FrameType get(int value){
		return map.get(value);
	}
	
	static Map<Integer,FrameType> map;
	static{
		map = new HashMap<Integer,FrameType>();
		FrameType[] types = FrameType.values();
		for(FrameType type:types){
			map.put(type.value, type);
		}
	}
}
