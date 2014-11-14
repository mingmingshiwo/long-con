package com.rongzm.mq;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import com.rongzm.push.MqMessage;

public class MqProducor extends MqEndPoint{

	public MqProducor(String queueName) {
		super(queueName);
	}

	int capacity = 8*3;
	public void sendMqMessage(MqMessage mqMessage){
		ByteBuf buf = ByteBufAllocator.DEFAULT.heapBuffer(capacity);
		buf.writeLong(mqMessage.getMsgId());
		buf.writeLong(mqMessage.getUid());
		buf.writeLong(mqMessage.getSid());
		byte[] bs = new byte[capacity];
		buf.getBytes(0, bs);
		try {
			super.channel.basicPublish("", queueName, null, bs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
