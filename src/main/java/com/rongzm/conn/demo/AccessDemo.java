package com.rongzm.conn.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.rongzm.conn.impl.SimpleAccess;

public class AccessDemo {
	public static void main(String[] args) throws Exception{
		SimpleAccess server = new SimpleAccess();
		server.start();
		
		System.out.println("Insert cmd...");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=br.readLine())!=null){
			server.broadcast(s);
		}
	}
}
