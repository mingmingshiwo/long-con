package com.rongzm.conn.handler;

import com.rongzm.conn.common.Constant;
import com.rongzm.conn.pojo.Message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToByteEncoder;

@Sharable
public class MessageEncoder extends MessageToByteEncoder<Message>{

	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out)
			throws Exception {
		int businessType = message.getBusinessType().value();
		int length = message.getLength();
		byte[] bs = message.getBody().getBytes(Constant.UTF8);
		
		out.writeInt(businessType);
		out.writeInt(length);
		out.writeBytes(bs);
	}

}
