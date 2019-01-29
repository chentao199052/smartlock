package com.qingyi.model;

public class Roompow {
	private String gatewaycode;
	private String gatewaycode2;
	private String roomcode;
	private Integer level;
	public Roompow() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param gatewaycode 门锁归属网关通讯ID
	 * @param gatewaycode2  门锁归属网关唯一ID
	 * @param roomcode 房间编号
	 * @param level 1=A0,2=A1,3=A2,4=A3
	 */
	public Roompow(String gatewaycode, String gatewaycode2, String roomcode, Integer level) {
		super();
		this.gatewaycode = gatewaycode;
		this.gatewaycode2 = gatewaycode2;
		this.roomcode = roomcode;
		this.level = level;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
