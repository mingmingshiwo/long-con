package com.rongzm.conn.pojo;


public class Message {
	BusinessType businessType;
	MessageType messageType;
	byte[] body;

	public Message() {
	}

	public Message(BusinessType businessType, MessageType messageType,
			byte[] body) {
		super();
		this.businessType = businessType;
		this.messageType = messageType;
		this.body = body;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

	
	
}
