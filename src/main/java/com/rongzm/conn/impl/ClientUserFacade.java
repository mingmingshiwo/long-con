package com.rongzm.conn.impl;

import com.rongzm.conn.Client;
import com.rongzm.conn.ClientUser;
import com.rongzm.conn.CustomMessageHandler;
import com.rongzm.conn.pojo.CustomMessage;

public abstract class ClientUserFacade implements ClientUser{

	private Client client;
	
	@Override
	public void start() {
		client = new SimpleClient("1");
		client.setCustomMessageHanlder(new CustomMessageHandler() {
			@Override
			public void onReceiveCustomMessage0(CustomMessage customMessage) {
				onReceiveCustomMessage(customMessage);
			}
		});
	}
	
}
