package com.qingyi.model;
/**
 * 房间返回信息
 * @author Administrator
 *
 */
public class RoomResult {
	private String orderId;
	private String gatewaycode;
	private String roomcode;
	public RoomResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param orderId  ID
	 * @param gatewaycode 网关通讯ID
	 * @param roomcode 房间编号
	 */
	public RoomResult(String orderId, String gatewaycode, String roomcode) {
		super();
		this.orderId = orderId;
		this.gatewaycode = gatewaycode;
		this.roomcode = roomcode;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGatewaycode() {
		return gatewaycode;
	}
	public void setGatewaycode(String gatewaycode) {
		this.gatewaycode = gatewaycode;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	@Override
	public String toString() {
		return "RoomResult [orderId=" + orderId + ", gatewaycode=" + gatewaycode + ", roomcode=" + roomcode + "]";
	}
	
	
}
