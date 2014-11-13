package com.rongzm.conn.handler;

import java.util.List;

import com.rongzm.conn.pojo.frame.CustomMessageFrame;
import com.rongzm.conn.pojo.frame.Frame;
import com.rongzm.conn.pojo.frame.FrameType;
import com.rongzm.conn.pojo.frame.InnerMessageFrame;
import com.rongzm.conn.pojo.frame.LoginFrame;
import com.rongzm.conn.pojo.frame.PingFrame;
import com.rongzm.conn.pojo.frame.PongFrame;
import com.rongzm.conn.pojo.frame.RegistFrame;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;

public class FrameDecoder extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		if(in.readableBytes()<6){
			return;
		}
		
		in.markReaderIndex();
		
		int magicNumber = in.readByte();
		if(magicNumber != 'M'){
			in.resetReaderIndex();
			throw new CorruptedFrameException("Invalid MagicNumber:" + magicNumber);
		}
		
		int type = in.readByte();
		
		int dataLength = in.readInt();
		if(in.readableBytes() < dataLength){
			in.resetReaderIndex();
			return;
		}
		
		ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer(dataLength);
		in.readBytes(byteBuf);
		
		Frame frame = convert(type);
		frame.assemble(byteBuf);
		out.add(frame);
		
	}

	private Frame convert(int type){
		FrameType frameType = FrameType.get(type);
		switch(frameType){
			case PING:
				return new PingFrame();
			case PONG:
				return new PongFrame();
			case REGIST:
				return new RegistFrame();
			case LOGIN:
				return new LoginFrame();
			case INNER:
				return new InnerMessageFrame();
			case CUSTOM:
				return new CustomMessageFrame();
			default:
				throw new RuntimeException("Invalid frame type:" + type);
		}
	}
}
