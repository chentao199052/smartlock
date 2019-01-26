package com.qingyi.model;

public class AuthRestAndOpen {
	private String locktype;
	private String gatewaycode;
	private String gatewaycode2;
	private String roomcode;
	private String roomcode2;
	private Integer timeout;
	private String callbackurl;
	public AuthRestAndOpen() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param locktype 门锁类型
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode 房间编号
	 * @param roomcode2 
	 * @param timeout
	 * @param callbackurl
	 */
	public AuthRestAndOpen(String locktype, String gatewaycode, String gatewaycode2, String roomcode, String roomcode2,
			Integer timeout, String callbackurl) {
		super();
		this.locktype = locktype;
		this.gatewaycode = gatewaycode;
		this.gatewaycode2 = gatewaycode2;
		this.roomcode = roomcode;
		this.roomcode2 = roomcode2;
		this.timeout = timeout;
		this.callbackurl = callbackurl;
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
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public String getCallbackurl() {
		return callbackurl;
	}
	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}
	
	
	
}
