package com.rongzm.conn.impl;

import java.net.InetSocketAddress;

import com.rongzm.conn.AbstractClient;

public class SimpleClient extends AbstractClient {

	String id;
	
	public SimpleClient(String id) {
		this.id = id;
	}
	
	@Override
	public InetSocketAddress remoteAddress() {
		return new InetSocketAddress("localhost", 999);
	}

	@Override
	public String getId() {
		return id;
	}
}
