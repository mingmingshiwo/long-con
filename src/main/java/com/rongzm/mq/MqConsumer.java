package com.rongzm.mq;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class MqConsumer extends MqEndPoint implements Runnable,Consumer{

	private ExecutorService exec = Executors.newFixedThreadPool(1);
	private Consumer c;
	
	public MqConsumer(String queueName,Consumer c) {
		super(queueName);
		exec.execute(this);
		this.c = c;
	}

	@Override
	public void handleCancel(String arg0) throws IOException {
		c.handleCancel(arg0);
		
	}

	@Override
	public void handleCancelOk(String arg0) {
		c.handleCancelOk(arg0);
		
	}

	@Override
	public void handleConsumeOk(String arg0) {
		c.handleConsumeOk(arg0);
	}

	@Override
	public void handleDelivery(String arg0, Envelope arg1,
			BasicProperties arg2, byte[] arg3) throws IOException {
		c.handleDelivery(arg0, arg1, arg2, arg3);
	}

	@Override
	public void handleRecoverOk(String arg0) {
		c.handleRecoverOk(arg0);
	}

	@Override
	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		c.handleShutdownSignal(arg0, arg1);
	}

	@Override
	public void run() {
		try {
			super.channel.basicConsume(queueName, true,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
