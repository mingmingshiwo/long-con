package com.rongzm.conn.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Iterator;
import java.util.Map;

import com.rongzm.conn.pojo.frame.Frame;
import com.rongzm.conn.pojo.frame.LoginFrame;

public class ServerInHandler extends SimpleChannelInboundHandler<Frame> {

	private Map<String, ChannelHandlerContext> clients;

	public ServerInHandler(Map<String, ChannelHandlerContext> clients) {
		this.clients = clients;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Frame frame)
			throws Exception {
		if(frame instanceof LoginFrame){
			LoginFrame loginFrame = (LoginFrame)frame;
			String id = loginFrame.getId();
			clients.put(id,ctx);
		}
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		boolean delete = false;
		synchronized (clients) {
			Iterator<ChannelHandlerContext> it = clients.values().iterator();
			ChannelHandlerContext c;
			while (it.hasNext()) {
				c = it.next();
				if (c.equals(ctx)) {
					it.remove();
					delete = true;
					break;
				}
			}
		}
		if (!delete) {
			System.err.println("没删成功！" + ctx);
		}
	}
}
