package com.rongzm.conn;

public interface ServerSender {
	public void send(int id,String msg);
	public void broadcast(String msg);
}
