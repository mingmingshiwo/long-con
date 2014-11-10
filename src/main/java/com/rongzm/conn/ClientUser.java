package com.rongzm.conn;

import com.rongzm.conn.pojo.CustomMessage;

public interface ClientUser {
	public void onReceiveCustomMessage(CustomMessage customMessage);
	public void start();
}
