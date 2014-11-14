package com.rongzm.push;

public interface Consumer {
	public void consume(MqMessage mqMessage);
}
