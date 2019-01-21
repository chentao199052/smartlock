package com.qingyi.model;

public class AuthRestAndOpen {
	private String locktype;
	private String gatewaycode;
	private String gatewaycode2;
	private String roomcode;
	private String roomcode2;
	public AuthRestAndOpen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthRestAndOpen(String locktype, String gatewaycode, String gatewaycode2, String roomcode, String roomcode2) {
		super();
		this.locktype = locktype;
		this.gatewaycode = gatewaycode;
		this.gatewaycode2 = gatewaycode2;
		this.roomcode = roomcode;
		this.roomcode2 = roomcode2;
	}
	public String getLocktype() {
		return locktype;
	}
	public void setLocktype(String locktype) {
		this.locktype = locktype;
	}
	public String getGatewaycode() {
		return gatewaycode;
	}
	public void setGatewaycode(String gatewaycode) {
		this.gatewaycode = gatewaycode;
	}
	public String getGatewaycode2() {
		return gatewaycode2;
	}
	public void setGatewaycode2(String gatewaycode2) {
		this.gatewaycode2 = gatewaycode2;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public String getRoomcode2() {
		return roomcode2;
	}
	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	
	
	
}
