package com.rongzm.conn.pojo.frame;

public class PongFrame extends HeartbeatFrame{

	@Override
	public FrameType type() {
		return FrameType.PONG;
	}

}
