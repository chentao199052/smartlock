package com.qingyi.model;

public class AuthTotal {
	private String locktype;
	private Integer type;
	private String gatewaycode;
	private String gatewaycode2;
	private String roomcode;
	private String roomcode2;
	public AuthTotal() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param locktype        门锁类型
	 * @param type            1强制锁门 2非强制锁门      1常开，2常闭     1允许离线授权，2禁止离线授权
	 * @param gatewaycode     门锁归属网关通讯ID
	 * @param gatewaycode2	      门锁归属网关唯一ID	
	 * @param roomcode		     房间编号
	 * @param roomcode2                    门锁唯一ID
	 */
	public AuthTotal(String locktype, Integer type, String gatewaycode, String gatewaycode2, String roomcode,
			String roomcode2) {
		super();
		this.locktype = locktype;
		this.type = type;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
