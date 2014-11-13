package com.rongzm.conn.pojo.frame;

public abstract class MessageFrame extends Frame{
	protected String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
