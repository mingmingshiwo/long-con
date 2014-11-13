package com.rongzm.conn.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

import java.util.Map;

public class ServerInitializer extends ChannelInitializer<Channel> {
	private static final FrameEncoder ENCODER = new FrameEncoder();
	
	private Map<String, ChannelHandlerContext> clients;

	public ServerInitializer(Map<String, ChannelHandlerContext> clients) {
		this.clients = clients;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(ENCODER);
		pipeline.addLast(new FrameDecoder());
		pipeline.addLast(new ServerInHandler(clients));
	}
}
