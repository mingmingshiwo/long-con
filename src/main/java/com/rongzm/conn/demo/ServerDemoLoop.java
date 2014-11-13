package com.rongzm.conn.demo;

import java.util.concurrent.TimeUnit;

import com.rongzm.conn.impl.SimpleServer;

public class ServerDemoLoop {
	public static void main(String[] args) throws Exception{
		SimpleServer server = new SimpleServer();
		server.start();
		
		TimeUnit.SECONDS.sleep(10);
		for(int i=0;i<10000;i++){
			server.broadcast(String.valueOf(i));
		}
	}
}
