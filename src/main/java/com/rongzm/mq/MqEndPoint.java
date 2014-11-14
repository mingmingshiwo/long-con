package com.rongzm.mq;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class MqEndPoint {
	protected String queueName;
	protected Channel channel;
	
	public MqEndPoint(String queueName){
		this.queueName = queueName;
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try {
			Connection connection = factory.newConnection();
			this.channel = connection.createChannel();
			channel.queueDeclare(queueName, false, false, false, null);
		} catch (IOException e) {
			throw new RuntimeException("rabbitmq init fail", e);
		}
		
	}
}
