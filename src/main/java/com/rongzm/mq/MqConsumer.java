package com.rongzm.mq;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.rabbitmq.client.Consumer;

public class MqConsumer extends MqEndPoint implements Runnable{

	private ExecutorService exec = Executors.newFixedThreadPool(1);
	private Consumer c;
	
	public MqConsumer(String queueName,Consumer c) {
		super(queueName);
		exec.execute(this);
		this.c = c;
	}


	@Override
	public void run() {
		try {
			super.channel.basicConsume(queueName, true,c);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
