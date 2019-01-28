package com.qingyi.model;

public class PowResult {
	private String orderId;
	private String gatewaycode;
	private String roomcode;
	private String ptype;
	public PowResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PowResult(String orderId, String gatewaycode, String roomcode, String ptype) {
		super();
		this.orderId = orderId;
		this.gatewaycode = gatewaycode;
		this.roomcode = roomcode;
		this.ptype = ptype;
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
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
	
}
