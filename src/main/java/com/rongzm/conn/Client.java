package com.rongzm.conn;


public interface Client {
	public String getId();
	public void connect();
	public void setCustomMessageHanlder(CustomMessageHandler handler);
}
