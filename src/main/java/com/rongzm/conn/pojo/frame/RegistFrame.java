package com.rongzm.conn.pojo.frame;

import io.netty.buffer.ByteBuf;

public class RegistFrame extends IdentifyFrame{

	@Override
	public void assemble(ByteBuf byteBuf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ByteBuf toByteBuf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FrameType type() {
		return FrameType.REGIST;
	}

}
