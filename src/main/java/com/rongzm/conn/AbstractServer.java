package com.rongzm.conn;

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

import com.rongzm.conn.handler.ServerInitializer;
import com.rongzm.conn.pojo.BusinessType;
import com.rongzm.conn.pojo.Message;

public abstract class AbstractServer implements Server {

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

	public void send(String id, String msg) {
		ChannelHandlerContext c = clients.get(id);
		if (c == null) {
			System.err.println("客户端已经断开连接");
			return;
		}
		Message message = new Message(BusinessType.SINGLE,msg);
		c.writeAndFlush(message);
	}

	public void broadcast(String msg) {
		Message message = new Message(BusinessType.BROADCAST,msg);
		Iterator<ChannelHandlerContext> it = clients.values().iterator();
		ChannelHandlerContext c;
		while (it.hasNext()) {
			c = it.next();
			c.writeAndFlush(message);
		}
	}
}
