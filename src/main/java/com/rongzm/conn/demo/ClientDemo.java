package com.rongzm.conn.demo;

import com.rongzm.conn.impl.SimpleClient;

public class ClientDemo {
	public static void main(String[] args) {
		SimpleClient client = new SimpleClient("1");
		client.connect();
	}
}
