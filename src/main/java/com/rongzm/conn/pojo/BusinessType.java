package com.rongzm.conn.pojo;

public enum BusinessType {
	PING(1),
	PONG(2),
	REGIST(3),
	LOGIN(4),
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
		BusinessType[] types = BusinessType.values();
		for(BusinessType type:types){
			if(type.value() == value){
				return type;
			}
		}
		throw new RuntimeException("not support value: " + value);
	}
}
