package com.rongzm.conn;

public interface ServerSender {
	/**
	 * @param id
	 * @param msg
	 */
	public void send(int id,String msg);
	/**
	 * @param msg
	 */
	public void broadcast(String msg);
}
