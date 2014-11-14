package com.rongzm.push.impl;

import com.rongzm.push.MqMessage;

public class MailBoxConsumer extends AbstractConsumer{

	@Override
	public void consume(MqMessage mqMessage) {
		System.err.println(mqMessage);
	}

}
