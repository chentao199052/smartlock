package com.qingyi.model;

public class Command {
	private String id;
	private String imei;
	private String messageCnt;
	private String time;
	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Command(String id, String imei, String messageCnt, String time) {
		super();
		this.id = id;
		this.imei = imei;
		this.messageCnt = messageCnt;
		this.time = time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getMessageCnt() {
		return messageCnt;
	}
	public void setMessageCnt(String messageCnt) {
		this.messageCnt = messageCnt;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
