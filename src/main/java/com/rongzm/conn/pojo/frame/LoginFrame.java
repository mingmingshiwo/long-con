package com.rongzm.conn.pojo.frame;

import com.rongzm.conn.common.Constant;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class LoginFrame extends IdentifyFrame {

	String id;

	public LoginFrame(){}
	
	public LoginFrame(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void assemble(ByteBuf byteBuf) {
		int l1 = byteBuf.readUnsignedByte();
		String c1 = byteBuf.readBytes(l1).toString(Constant.UTF8);
		this.id = c1;
	}

	@Override
	public ByteBuf toByteBuf() {
		byte[] c1 = id.getBytes(Constant.UTF8);
		int l1 = c1.length;
		ByteBuf buf = ByteBufAllocator.DEFAULT.heapBuffer();
		buf.writeByte(l1);
		buf.writeBytes(c1);
		return buf;
	}

	@Override
	public FrameType type() {
		return FrameType.LOGIN;
	}

}
