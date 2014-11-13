package com.rongzm.conn.pojo.frame;

import com.rongzm.conn.common.Constant;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class InnerMessageFrame extends MessageFrame{
	private InnerMessagePurposeType purpose;
	private String url;

	public InnerMessagePurposeType getPurpose() {
		return purpose;
	}
	public void setPurpose(InnerMessagePurposeType purpose) {
		this.purpose = purpose;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public void assemble(ByteBuf byteBuf) {
		int c1 = byteBuf.readUnsignedByte();
		this.setPurpose(InnerMessagePurposeType.get(c1));
		int l2 = byteBuf.readUnsignedByte();
		String c2 = byteBuf.readBytes(l2).toString(Constant.UTF8);
		this.setUrl(c2);
		int l3 = byteBuf.readUnsignedByte();
		String c3 = byteBuf.readBytes(l3).toString(Constant.UTF8);
		this.setContent(c3);
		
	}
	@Override
	public ByteBuf toByteBuf() {
		int c1 = purpose.value;
		byte[] c2 = url.getBytes(Constant.UTF8);
		int l2 = c2.length;
		byte[] c3 = content.getBytes(Constant.UTF8);
		int l3 = c3.length;
		ByteBuf byteBuf = ByteBufAllocator.DEFAULT.heapBuffer();
		byteBuf.writeByte(c1);
		byteBuf.writeByte(l2);
		byteBuf.writeBytes(c2);
		byteBuf.writeByte(l3);
		byteBuf.writeBytes(c3);
		return byteBuf;
	}
	@Override
	public FrameType type() {
		return FrameType.INNER;
	}
	@Override
	public String toString() {
		return "InnerMessageFrame [purpose=" + purpose + ", url=" + url
				+ ", content=" + content + "]";
	}
}
