package com.qingyi.model;

public class PowResult {
	private String orderId;
	private String roomcode;
	private String ptype;
	public PowResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param orderId
	 * @param roomcode 房间编号
	 * @param ptype	   功率等级	
	 */
	public PowResult(String orderId, String roomcode, String ptype) {
		super();
		this.orderId = orderId;
		this.roomcode = roomcode;
		this.ptype = ptype;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
