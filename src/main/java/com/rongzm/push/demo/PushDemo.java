package com.rongzm.push.demo;

import com.rongzm.push.MqMessage;
import com.rongzm.push.impl.AccessConsumer;
import com.rongzm.push.impl.MailBoxConsumer;
import com.rongzm.push.impl.SingleProducer;

public class PushDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AccessConsumer accessConsumer = new AccessConsumer();
		MailBoxConsumer mailBoxConsumer = new MailBoxConsumer();
		
		SingleProducer singleProducer = new SingleProducer();
		for(int i=0;i<10;i++){
			singleProducer.produce(new MqMessage(1l, 2l, (long)i));
		}
	}
}
