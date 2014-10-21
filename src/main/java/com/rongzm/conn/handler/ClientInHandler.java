package com.rongzm.conn.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.rongzm.conn.pojo.Message;
public class ClientInHandler extends SimpleChannelInboundHandler<Message> {
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message message)
			throws Exception {
		switch(message.getBusinessType()){
			case SINGLE:
				System.out.println(String.format("[S->C]", message.getBody()));
				break;
			case GROUP:
				System.err.println("[GROUP]" + message.getBody());
				break;
			case BROADCAST:
				System.err.println("[bc]" + message.getBody());
				break;
			default:
				throw new RuntimeException("Not support " + message);
		}
	}
}
