package com.rongzm.conn.pojo;

import java.util.HashMap;
import java.util.Map;

public enum BusinessType {
	PING(1),
	PONG(2),
	REGIST(3),
	LOGIN(4),
	//message
	SINGLE(5),
	GROUP(6),
	BROADCAST(7);
	
	int value;
	private BusinessType(int value){
		this.value = value;
	}
	
	public int value(){
		return value;
	}
	
	public static BusinessType get(int value){
		return map.get(value);
	}
	
	static Map<Integer,BusinessType> map;
	static{
		map = new HashMap<Integer,BusinessType>();
		BusinessType[] types = BusinessType.values();
		for(BusinessType type:types){
			map.put(type.value, type);
		}
	}
}
