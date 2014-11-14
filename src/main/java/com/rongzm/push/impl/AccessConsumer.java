package com.rongzm.push.impl;

import com.rongzm.push.MqMessage;

public class AccessConsumer extends AbstractConsumer{

	@Override
	public void consume(MqMessage mqMessage) {
		System.out.println(mqMessage);
	}

}
