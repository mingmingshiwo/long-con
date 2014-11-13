package com.rongzm.conn.pojo.frame;

public class PingFrame extends HeartbeatFrame {

	@Override
	public FrameType type() {
		return FrameType.PING;
	}

}
