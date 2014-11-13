package com.rongzm.conn.handler;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToByteEncoder;

import com.rongzm.conn.pojo.frame.Frame;

@Sharable
public class FrameEncoder extends MessageToByteEncoder<Frame>{

	Logger log = Logger.getLogger(getClass());
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Frame frame, ByteBuf out)
			throws Exception {
		out.writeByte('M');
		out.writeByte(frame.type().value());
		ByteBuf byteBuf = frame.toByteBuf();
		out.writeInt(byteBuf.readableBytes());
		out.writeBytes(byteBuf);
	}

}
