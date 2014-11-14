package com.rongzm.push.impl;

import java.util.List;

import com.rongzm.push.MqMessage;

public class BatchProducer extends AbstractProducer{
	
	public void produce(List<MqMessage> list){
		for(MqMessage msg:list){
			produce(msg);
		}
	};
}
