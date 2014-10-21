package com.rongzm.conn.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.rongzm.conn.common.Constant;
import com.rongzm.conn.pojo.BusinessType;
import com.rongzm.conn.pojo.Message;

public class MessageDecoder extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		if(in.readableBytes() < 8){
			return;
		}
		
		in.markReaderIndex();
		
		int businessType = in.readInt();
		int length = in.readInt();
		
		byte[] bs = new byte[length];
		in.readBytes(bs);
		String body = new String(bs,Constant.UTF8);
		out.add(new Message(BusinessType.get(businessType),length,body));
	}

}
