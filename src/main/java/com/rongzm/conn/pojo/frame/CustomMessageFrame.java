package com.rongzm.conn.pojo.frame;

import com.rongzm.conn.common.Constant;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class CustomMessageFrame extends MessageFrame{

	@Override
	public void assemble(ByteBuf byteBuf) {
		short l1 = byteBuf.readUnsignedByte();
		String c1 = byteBuf.readBytes(l1).toString(Constant.UTF8);
		this.setContent(c1);
	}

	@Override
	public ByteBuf toByteBuf() {
		byte[] c1 = getContent().getBytes(Constant.UTF8);
		int l1 = c1.length;
		ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
		byteBuf.writeByte(l1);
		byteBuf.writeBytes(c1);
		return byteBuf;
	}

	@Override
	public FrameType type() {
		return FrameType.CUSTOM;
	}

	@Override
	public String toString() {
		return "CustomMessageFrame [content=" + content + "]";
	}
}
