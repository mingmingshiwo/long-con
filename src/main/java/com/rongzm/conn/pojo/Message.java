package com.rongzm.conn.pojo;

import com.rongzm.conn.common.Constant;

public class Message {
	BusinessType businessType;
	Integer length;
	String body;

	public Message() {
	}

	public Message(BusinessType businessType,String body){
		this.businessType = businessType;
		this.length = body.getBytes(Constant.UTF8).length;
		this.body = body;
	}
	
	public Message(BusinessType businessType, Integer length, String body) {
		this.businessType = businessType;
		this.length = length;
		this.body = body;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
