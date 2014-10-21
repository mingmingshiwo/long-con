package com.rongzm.conn.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Iterator;
import java.util.Map;

import com.rongzm.conn.pojo.BusinessType;
import com.rongzm.conn.pojo.Message;

public class ServerInHandler extends SimpleChannelInboundHandler<Message> {

	private Map<String, ChannelHandlerContext> clients;

	public ServerInHandler(Map<String, ChannelHandlerContext> clients) {
		this.clients = clients;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message message)
			throws Exception {
		if(message.getBusinessType() == BusinessType.LOGIN){
			String id = message.getBody();
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
					System.out.println("[delete]");
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
