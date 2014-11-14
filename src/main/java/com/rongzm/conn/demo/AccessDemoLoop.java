package com.rongzm.conn.demo;

import java.util.concurrent.TimeUnit;

import com.rongzm.conn.impl.SimpleAccess;

public class AccessDemoLoop {
	public static void main(String[] args) throws Exception{
		SimpleAccess server = new SimpleAccess();
		server.start();
		
		TimeUnit.SECONDS.sleep(10);
		for(int i=0;i<10000;i++){
			server.broadcast(String.valueOf(i));
		}
	}
}
