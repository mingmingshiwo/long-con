package com.rongzm.conn.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

public class ClientInitializer extends ChannelInitializer<Channel> {

	private static final FrameEncoder ENCODER = new FrameEncoder();

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(ENCODER);
		pipeline.addLast(new FrameDecoder());
		pipeline.addLast(new ClientInHandler());
	}

}
