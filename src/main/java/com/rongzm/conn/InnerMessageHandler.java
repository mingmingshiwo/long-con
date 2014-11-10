package com.rongzm.conn;

import com.rongzm.conn.pojo.InnerMessage;

public interface InnerMessageHandler {
	public void onReceiveInnerMessage(InnerMessage message);
}
