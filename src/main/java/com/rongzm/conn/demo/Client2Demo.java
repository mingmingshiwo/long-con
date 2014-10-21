package com.rongzm.conn.demo;

import com.rongzm.conn.impl.SimpleClient;

public class Client2Demo {
	public static void main(String[] args) {
		SimpleClient client = new SimpleClient("2");
		client.connect();
	}
}
