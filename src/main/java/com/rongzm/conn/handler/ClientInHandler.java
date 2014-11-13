package com.rongzm.conn.handler;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import com.rongzm.conn.pojo.frame.Frame;
import com.rongzm.conn.pojo.frame.FrameType;
import com.rongzm.conn.pojo.frame.PongFrame;
public class ClientInHandler extends SimpleChannelInboundHandler<Frame> {
	
	Logger log = Logger.getLogger(getClass());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Frame frame)
			throws Exception {
		FrameType type = frame.type();
		log.debug(type);
		switch(type){
			case PING:
				ctx.write(new PongFrame());
				break;
			case INNER:
				System.out.println("[rec] [inner]" + frame);
				break;
			case CUSTOM:
				System.out.println("[rec] [custom]" + frame);
				break;
			default:
				throw new RuntimeException("Unsupport frameType:" + type);
		}
		
		
//		switch(message.getBusinessType()){
//			case SINGLE:
//				System.out.println(String.format("[S->C]", message.getBody()));
//				break;
//			case GROUP:
//				System.err.println("[GROUP]" + message.getBody());
//				break;
//			case BROADCAST:
//				System.err.println("[bc]" + message.getBody());
//				break;
//			default:
//				throw new RuntimeException("Not support " + message);
//		}
	}
}
