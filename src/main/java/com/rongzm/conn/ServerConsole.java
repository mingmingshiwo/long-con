package com.rongzm.conn;

public interface ServerConsole {
	public void send(String id, String msg);
	public void broadcast(String msg);
}
