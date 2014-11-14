package com.rongzm.push;

public class MqMessage {
	Long msgId;
	Long uid;
	Long sid;

	public MqMessage(Long msgId, Long sid, Long uid) {
		super();
		this.msgId = msgId;
		this.uid = uid;
		this.sid = sid;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "MqMessage [msgId=" + msgId + ", uid=" + uid + ", sid=" + sid
				+ "]";
	}

}
