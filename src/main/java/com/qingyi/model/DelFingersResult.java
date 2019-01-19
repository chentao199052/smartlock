package com.qingyi.model;

import java.sql.Timestamp;

public class DelFingersResult {
	
	private String orderId;
	
	private String fingercode;
	
	private String roomcode2;

	public DelFingersResult() {
		super();
	}

	public DelFingersResult(String orderId, String fingercode, String roomcode2) {
		super();
		this.orderId = orderId;
		this.fingercode = fingercode;
		this.roomcode2 = roomcode2;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getFingercode() {
		return fingercode;
	}

	public void setFingercode(String fingercode) {
		this.fingercode = fingercode;
	}

	public String getRoomcode2() {
		return roomcode2;
	}

	public void setRoomcode2(String roomcode2) {
		this.roomcode2 = roomcode2;
	}
	
	@Override
	public String toString() {
		return "DelFingersResult [orderId=" + orderId + ", fingercode=" + fingercode + ", roomcode2=" + roomcode2 + "]";
	}
}
