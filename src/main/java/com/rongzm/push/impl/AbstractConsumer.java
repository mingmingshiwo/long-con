package com.rongzm.push.impl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.io.IOException;

import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rongzm.conn.common.Constant;
import com.rongzm.mq.MqConsumer;
import com.rongzm.push.Consumer;
import com.rongzm.push.MqMessage;

public abstract class AbstractConsumer implements Consumer{
	
	MqConsumer mqConsumer = new MqConsumer(Constant.MQ_NAME, new com.rabbitmq.client.Consumer() {
		
		@Override
		public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void handleRecoverOk(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		int capacity = 8*3;
		@Override
		public void handleDelivery(String arg0, Envelope arg1,
				BasicProperties arg2, byte[] arg3) throws IOException {
			ByteBuf buf = ByteBufAllocator.DEFAULT.heapBuffer(capacity);
			buf.writeBytes(arg3);
			Long msgId = buf.readLong();
			Long sid = buf.readLong();
			Long uid = buf.readLong();
			MqMessage mqMessage = new MqMessage(msgId, sid, uid);
			consume(mqMessage);
		}
		
		@Override
		public void handleConsumeOk(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void handleCancelOk(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void handleCancel(String arg0) throws IOException {
			// TODO Auto-generated method stub
			
		}
	});
}
