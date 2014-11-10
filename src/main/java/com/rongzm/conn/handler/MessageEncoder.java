package com.rongzm.conn.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.rongzm.conn.pojo.Message;

@Sharable
public class MessageEncoder extends MessageToByteEncoder<Message>{

	@Override
	protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out)
			throws Exception {
		int businessType = message.getBusinessType().value();
		int messageType = message.getMessageType().value();
		byte[] bs = message.getBody();
		int length = bs.length;
		
		out.writeInt(businessType);
		out.writeInt(messageType);
		out.writeInt(length);
		out.writeBytes(bs);
	}

}
