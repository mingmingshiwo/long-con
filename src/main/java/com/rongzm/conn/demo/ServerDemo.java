package com.rongzm.conn.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.rongzm.conn.impl.SimpleServer;

public class ServerDemo {
	public static void main(String[] args) throws Exception{
		SimpleServer server = new SimpleServer();
		server.start();
		
		System.out.println("Insert cmd...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null){
			server.broadcast(s);
		}
	}
}
