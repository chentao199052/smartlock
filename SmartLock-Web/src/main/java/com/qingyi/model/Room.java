package com.qingyi.model;
/**
 * 门锁状态查询
 * @author Administrator
 *
 */
public class Room {
	private String gatewaycode;
	private String gatewaycode2;
	private String roomcode;
	public String getGatewaycode() {
		return gatewaycode;
	}
	
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param gatewaycode 网关通讯ID
	 * @param gatewaycode2 网关唯一ID
	 * @param roomcode 房间编号
	 */
	public Room(String gatewaycode, String gatewaycode2, String roomcode) {
		super();
		this.gatewaycode = gatewaycode;
		this.gatewaycode2 = gatewaycode2;
		this.roomcode = roomcode;
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
	
	
}
