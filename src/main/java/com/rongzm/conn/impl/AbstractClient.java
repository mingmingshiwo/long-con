package com.rongzm.conn.impl;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

import com.rongzm.conn.Client;
import com.rongzm.conn.handler.ClientInitializer;
import com.rongzm.conn.pojo.frame.LoginFrame;

public abstract class AbstractClient implements Client {

	protected abstract InetSocketAddress remoteAddress();

	protected Bootstrap bootstrap;

	protected Channel mainLine;

	public AbstractClient() {
		bootstrap = new Bootstrap();
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
				.handler(new ClientInitializer());
	}

	@Override
	public void connect() {
		final ChannelFuture f = bootstrap.connect(remoteAddress());
		f.addListener(new ChannelFutureListener() {

			@Override
			public void operationComplete(ChannelFuture future)
					throws Exception {
				future.channel().writeAndFlush(new LoginFrame(getId()));
			}

		});
		f.syncUninterruptibly();
		Channel channel = f.channel();
		mainLine = channel;
		channel.closeFuture().syncUninterruptibly();
	}
	
}
