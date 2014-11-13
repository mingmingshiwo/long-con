package com.rongzm.conn.impl;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.internal.chmv8.ConcurrentHashMapV8;

import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

import org.apache.log4j.Logger;

import com.rongzm.conn.Server;
import com.rongzm.conn.handler.ServerInitializer;
import com.rongzm.conn.pojo.frame.CustomMessageFrame;
import com.rongzm.conn.pojo.frame.InnerMessageFrame;
import com.rongzm.conn.pojo.frame.InnerMessagePurposeType;

public abstract class AbstractServer implements Server {

	Logger log = Logger.getLogger(getClass());
	
	static ConcurrentMap<String, ChannelHandlerContext> clients = new ConcurrentHashMapV8<String, ChannelHandlerContext>();

	protected ServerBootstrap bootstrap;

	// 启动注册 返回端口号
	protected abstract int regist();

	public AbstractServer() {
		bootstrap = new ServerBootstrap();
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		bootstrap.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.handler(new LoggingHandler(LogLevel.DEBUG))
				.childHandler(new ServerInitializer(clients));
	}

	@Override
	public void start() {
		bootstrap.bind(regist()).syncUninterruptibly();
	}

	public void sendCustom(String id, String msg) {
		ChannelHandlerContext c = clients.get(id);
		if (c == null) {
			System.err.println("客户端已经断开连接");
			return;
		}
		CustomMessageFrame frame = new CustomMessageFrame();
		frame.setContent("wtf");
		c.writeAndFlush(frame);
	}

	public void broadcast(String msg) {
//		CustomMessageFrame frame = new CustomMessageFrame();
//		frame.setContent(msg);
		InnerMessageFrame frame = new InnerMessageFrame();
		frame.setContent(msg);
		frame.setPurpose(InnerMessagePurposeType.WEBSITE);
		frame.setUrl("http://www.163.com");
		
		log.debug(clients.size());
		Iterator<ChannelHandlerContext> it = clients.values().iterator();
		ChannelHandlerContext c;
		while (it.hasNext()) {
			c = it.next();
			c.writeAndFlush(frame);
		}
	}
}
