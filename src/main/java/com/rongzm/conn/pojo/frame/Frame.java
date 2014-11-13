package com.rongzm.conn.pojo.frame;

import io.netty.buffer.ByteBuf;

public abstract class Frame {
	public abstract FrameType type();
	public abstract void assemble(ByteBuf byteBuf);
	public abstract ByteBuf toByteBuf();
}
