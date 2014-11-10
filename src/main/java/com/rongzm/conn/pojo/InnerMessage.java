package com.rongzm.conn.pojo;

public class InnerMessage {
	private String url;
	private String body;
	public InnerMessage(String url, String body) {
		super();
		this.url = url;
		this.body = body;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String geBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
