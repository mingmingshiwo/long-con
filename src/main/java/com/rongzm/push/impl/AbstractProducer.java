package com.rongzm.push.impl;

import com.rongzm.conn.common.Constant;
import com.rongzm.mq.MqProducor;
import com.rongzm.push.MqMessage;
import com.rongzm.push.Producer;

public abstract class AbstractProducer implements Producer{

	MqProducor mqProducor = new MqProducor(Constant.MQ_NAME);
	
	@Override
	public void produce(MqMessage mqMessage) {
		mqProducor.sendMqMessage(mqMessage);
	}
	
}
